package kr.jay.rental.domain.model

import kr.jay.rental.domain.model.vo.Item
import java.time.LocalDate

class RentalItem private constructor(
    private var item: Item,
    private var rentDate: LocalDate,
    private var overdued: Boolean,
    private var overdueDate: LocalDate,
)  {
    companion object{
        fun createRentalItem(item: Item) =
            RentalItem(
                item,
                LocalDate.now(),
                false,
                LocalDate.now().plusDays(14)
            )
    }
}
