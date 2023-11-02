package kr.jay.rental.domain.model.vo

import kr.jay.rental.domain.model.RentalItem
import java.time.LocalDate

data class ReturnItem private constructor(
    private val rentalItem: RentalItem,
    private val returnDate: LocalDate
) {

    companion object{
        fun createReturnItem(rentalItem: RentalItem) =
            ReturnItem(
                rentalItem,
                LocalDate.now()
            )
    }
}
