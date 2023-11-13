package kr.jay.rental.application.usecase

import kr.jay.rental.domain.model.RentalCard
import kr.jay.rental.domain.model.vo.IdName
import kr.jay.rental.domain.model.vo.Item

/**
 * CompensationUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/13/23
 */
interface CompensationUseCase {
    fun cancelRentItem(idName: IdName, item: Item): RentalCard
    fun cancelReturnItem(idName: IdName, item: Item, point: Long):RentalCard
    fun cancelMakeAvailableRental(idName: IdName, point: Long): Long
}