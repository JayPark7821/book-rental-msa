package kr.jay.rental.framework.jpa

import kr.jay.rental.application.outputport.RentalCardOutputPort
import kr.jay.rental.domain.model.RentalCard
import org.springframework.stereotype.Repository

/**
 * RentalCardJpaAdapter
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
@Repository
class RentalCardJpaAdapter(
    private val rentalCardRepository: RentalCardRepository
): RentalCardOutputPort {

    override fun loadRentalCard(userId: String): RentalCard? {
        return rentalCardRepository.findByMemberId(userId)
    }

    override fun save(rentalCard: RentalCard): RentalCard {
        return rentalCardRepository.save(rentalCard)
    }
}