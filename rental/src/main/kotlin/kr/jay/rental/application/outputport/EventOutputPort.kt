package kr.jay.rental.application.outputport

import kr.jay.rental.domain.event.ItemRented
import kr.jay.rental.domain.event.ItemReturned
import kr.jay.rental.domain.event.OverdueCleared

/**
 * EventOutputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/9/23
 */
interface EventOutputPort {
    fun occurRentalEvent(itemRented: ItemRented)
    fun occurReturnEvent(itemReturned: ItemReturned)
    fun occurOverdueClearedEvent(overdueCleared: OverdueCleared)

}