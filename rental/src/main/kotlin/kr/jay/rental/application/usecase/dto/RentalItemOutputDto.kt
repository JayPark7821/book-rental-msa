package kr.jay.rental.application.usecase.dto

import kr.jay.rental.domain.model.RentalItem
import java.time.LocalDate

/**
 * RentalItemOutputDto
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
data class RentalItemOutputDto(
    val itemNo: Int,
    val itemTitle: String,

    val rentDate: LocalDate,
    val overdued: Boolean,
    val overdueDate: LocalDate,
) {
    companion object {
        fun mapToDto(rentalItem: RentalItem) = RentalItemOutputDto(
            itemNo = rentalItem.item.no,
            itemTitle = rentalItem.item.title,
            rentDate = rentalItem.rentDate,
            overdued = rentalItem.overdued,
            overdueDate = rentalItem.overdueDate
        )

    }
}
