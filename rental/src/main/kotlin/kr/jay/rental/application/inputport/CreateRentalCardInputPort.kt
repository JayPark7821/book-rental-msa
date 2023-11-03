package kr.jay.rental.application.inputport

import kr.jay.rental.application.outputport.RentalCardOutputPort
import kr.jay.rental.application.usecase.CreateRentalCardUseCase
import kr.jay.rental.application.usecase.dto.RentalCardOutputDto
import kr.jay.rental.application.usecase.dto.UserInputDto
import kr.jay.rental.domain.model.RentalCard
import kr.jay.rental.domain.model.vo.IDName
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * CreateRentalCardInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */

@Service
@Transactional
class CreateRentalCardInputPort(
    private val rentalCardOutputPort: RentalCardOutputPort
) :CreateRentalCardUseCase{

    override fun createRentalCard(userInputDto: UserInputDto): RentalCardOutputDto =
        RentalCard.createRentalCard(IDName(userInputDto.userId, userInputDto.userName)).let {
            rentalCardOutputPort.save(it)
            return RentalCardOutputDto.mapToDto(it)
        }

}