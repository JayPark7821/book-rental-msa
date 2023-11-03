package kr.jay.rental.application.inputport

import kr.jay.rental.application.outputport.RentalCardOutputPort
import kr.jay.rental.application.usecase.ClearOverdueItemUseCase
import kr.jay.rental.application.usecase.dto.ClearOverdueInfoDto
import kr.jay.rental.application.usecase.dto.RentalResultOutputDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * ClearOverdueInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
@Transactional
@Service
class ClearOverdueItemInputPort(
    private val rentalCardOutputPort: RentalCardOutputPort,
) : ClearOverdueItemUseCase {

    override fun clearOverdue(clearOverdueInfoDto: ClearOverdueInfoDto): RentalResultOutputDto {
        val rentalCard = rentalCardOutputPort.loadRentalCard(clearOverdueInfoDto.userId)
            ?: throw IllegalArgumentException("대여카드가 존재하지 않습니다.")
        rentalCard.makeAvailableRental(clearOverdueInfoDto.point)
        return RentalResultOutputDto.mapToDto(rentalCardOutputPort.save(rentalCard))
    }
}