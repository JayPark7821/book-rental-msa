package kr.jay.rental.domain.model

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import kr.jay.rental.domain.model.vo.Item
import java.time.LocalDate

@Embeddable
class RentalItem private constructor(
    @Embedded
    var item: Item,
    var rentDate: LocalDate,
    var overdued: Boolean,
    var overdueDate: LocalDate,
) {

    companion object {
        fun createRentalItem(item: Item) =
            RentalItem(
                item,
                LocalDate.now(),
                false,
                LocalDate.now().plusDays(14)
            )
    }


}
