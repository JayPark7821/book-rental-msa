package kr.jay.rental.domain.model.vo

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import kr.jay.rental.domain.model.RentalItem
import java.time.LocalDate

@Embeddable
data class ReturnItem private constructor(
    @Embedded
     val rentalItem: RentalItem,
     val returnDate: LocalDate
) {

    companion object{
        fun createReturnItem(rentalItem: RentalItem) =
            ReturnItem(
                rentalItem,
                LocalDate.now()
            )
    }
}
