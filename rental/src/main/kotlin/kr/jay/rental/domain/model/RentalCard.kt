package kr.jay.rental.domain.model

import kr.jay.rental.domain.model.vo.IDName
import kr.jay.rental.domain.model.vo.LateFee
import kr.jay.rental.domain.model.vo.RentStatus
import kr.jay.rental.domain.model.vo.RentalCardNo
import kr.jay.rental.domain.model.vo.ReturnItem

/**
 * RentalCard
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/2/23
 */
class RentalCard(
    private var rentalCardNo: RentalCardNo,
    private var member: IDName,
    private var rentStatus: RentStatus,
    private var lateFee: LateFee,
    private var rentalItemList : List<RentalItem> = mutableListOf(),
    private var returnItemList : List<ReturnItem> = mutableListOf(),
) {

    private fun addRentalItem(rentalItem: RentalItem) {
        rentalItemList = rentalItemList.plus(rentalItem)
    }

    private fun removeRentalItem(rentalItem: RentalItem) {
        rentalItemList = rentalItemList.minus(rentalItem)
    }

    private fun addReturnItem(returnItem: ReturnItem) {
        returnItemList = returnItemList.plus(returnItem)
    }

}