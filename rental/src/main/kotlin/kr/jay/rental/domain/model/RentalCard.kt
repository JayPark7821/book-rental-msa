package kr.jay.rental.domain.model

import jakarta.persistence.ElementCollection
import jakarta.persistence.Embedded
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import kr.jay.rental.domain.model.vo.*
import java.time.LocalDate
import java.time.Period

/**
 * RentalCard
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/2/23
 */
@Entity
class RentalCard private constructor(
    rentalCardNo: RentalCardNo,
    member: IDName,
    rentStatus: RentStatus,
    lateFee: LateFee,
) {
    @EmbeddedId
    var rentalCardNo = rentalCardNo
        private set
    @Embedded
    var member = member
        private set
    var rentStatus = rentStatus
        private set
    @Embedded
    var lateFee = lateFee
        private set
    @ElementCollection
    var rentalItemList: List<RentalItem> = mutableListOf()
        private set
    @ElementCollection
    var returnItemList: List<ReturnItem> = mutableListOf()
        private set
    companion object{
        // 대여카드 생성
        fun createRentalCard(creator: IDName) =
            RentalCard(
                RentalCardNo.createRentalCardNo(),
                creator,
                RentStatus.RENT_AVAILABLE,
                LateFee.createLateFee()
            )
    }

    // 대여처리
    fun rentItem(item: Item) : RentalCard{
        checkRentalAvailable()
        this.addRentalItem(RentalItem.createRentalItem(item))
        return this
    }

    private fun checkRentalAvailable() {
        if(this.rentStatus == RentStatus.RENT_UNAVAILABLE) {
            throw IllegalArgumentException("대여가 불가능한 상태입니다.")
        }
        if (this.rentalItemList.size > 5) {
            throw java.lang.IllegalArgumentException("대여가능한 아이템의 수를 초과하였습니다.")
        }
    }

    fun returnItem(item: Item, returnDate: LocalDate): RentalCard{
        this.rentalItemList.find { it.item == item }?.let {
            calculateLateFee(it, returnDate)
            this.addReturnItem(ReturnItem.createReturnItem(it))
            this.removeRentalItem(it)
        }
        return this
    }

    private fun calculateLateFee(rentalItem: RentalItem, returnDate: LocalDate) {
        if (returnDate > rentalItem.overdueDate) {
            val point = Period.between(rentalItem.overdueDate, returnDate).days * 10
            this.lateFee = this.lateFee.addPoint(point.toLong())

        }
    }

    fun overdueItem(item: Item) : RentalCard{
        this.rentalItemList.find { it.item == item }?.let {
            it.overdued = true
            this.rentStatus = RentStatus.RENT_UNAVAILABLE
            it.overdueDate= LocalDate.now().minusDays(1)
        }
        return this
    }

    fun makeAvailableRental(point:Long) : Long{
        if(this.rentalItemList.size != 0) throw IllegalArgumentException("대여중인 아이템이 있습니다.")
        if(this.lateFee.point != point) throw IllegalArgumentException("해당 포인트로 연체를 해제할 수 없습니다.")

        this.lateFee = lateFee.removePoint(point)
        if(this.lateFee.point == 0L) {
            this.rentStatus = RentStatus.RENT_AVAILABLE
        }
        return this.lateFee.point
    }

    private fun addRentalItem(rentalItem: RentalItem) {
        this.rentalItemList.plus(rentalItem)
    }

    private fun removeRentalItem(rentalItem: RentalItem) {
        this.rentalItemList.minus(rentalItem)
    }

    private fun addReturnItem(returnItem: ReturnItem) {
        this.returnItemList.plus(returnItem)
    }


}