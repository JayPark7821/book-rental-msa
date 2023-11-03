package kr.jay.rental.application.inputport

import kr.jay.rental.application.outputport.RentalCardOutputPort
import kr.jay.rental.application.usecase.OverdueItemUseCase
import kr.jay.rental.application.usecase.dto.RentalCardOutputDto
import kr.jay.rental.application.usecase.dto.UserItemInputDto
import kr.jay.rental.domain.model.vo.Item
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * OverDueItemInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */

@Service
@Transactional
class OverdueItemInputPort(
    private val rentalCardOutputPort: RentalCardOutputPort,
) : OverdueItemUseCase {

    override fun overdueItem(userItemInputDto: UserItemInputDto): RentalCardOutputDto {
        val rentalCard = rentalCardOutputPort.loadRentalCard(userItemInputDto.userId) ?: throw IllegalArgumentException(
            "대여카드가 존재하지 않습니다."
        )
        val overdueRentalCard = rentalCard.overdueItem(Item(userItemInputDto.itemId, userItemInputDto.itemTitle))
        return RentalCardOutputDto.mapToDto(rentalCardOutputPort.save(overdueRentalCard))

    }
}