package kr.jay.rental.application.usecase.dto

import kr.jay.rental.domain.model.RentalCard

/**
 * RentalCardOutputDto
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
data class RentalCardOutputDto(
    val rentalCardId: String,
    val memberId: String,
    val memberName: String,
    val rentStatus: String,
    val totalLateFee: Long,
    val totalRentalCnt: Long,
    val totalReturnCnt: Long,
    val totalOverduedCnt: Long,
){
    companion object{
        fun mapToDto(rental: RentalCard) = RentalCardOutputDto(
            rentalCardId = rental.rentalCardNo.no,
            memberId = rental.member.id,
            memberName = rental.member.name,
            rentStatus = rental.rentStatus.name,
            totalLateFee = rental.lateFee.point,
            totalRentalCnt = rental.rentalItemList.count().toLong(),
            totalReturnCnt = rental.returnItemList.count().toLong(),
            totalOverduedCnt = rental.rentalItemList.count { it.overdued }.toLong()
        )

    }
}
