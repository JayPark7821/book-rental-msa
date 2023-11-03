package kr.jay.rental.application.outputport

import kr.jay.rental.domain.model.RentalCard

/**
 * RentalCardOutputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
interface RentalCardOutputPort {
    fun loadRentalCard(userId: String): RentalCard?
    fun save(rentalCard: RentalCard): RentalCard
}