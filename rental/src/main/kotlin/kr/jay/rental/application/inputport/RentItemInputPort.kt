package kr.jay.rental.application.inputport

import kr.jay.rental.application.outputport.RentalCardOutputPort
import kr.jay.rental.application.usecase.RentItemUseCase
import kr.jay.rental.application.usecase.dto.RentalCardOutputDto
import kr.jay.rental.application.usecase.dto.UserItemInputDto
import kr.jay.rental.domain.model.RentalCard
import kr.jay.rental.domain.model.vo.IDName
import kr.jay.rental.domain.model.vo.Item
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RentItemInputPort(
    private val rentalCardOutputPort: RentalCardOutputPort,
) : RentItemUseCase {

    override fun rentItem(userItemInputDto: UserItemInputDto): RentalCardOutputDto {
        val rentalCard = (rentalCardOutputPort.loadRentalCard(userItemInputDto.userId) ?: RentalCard.createRentalCard(
            IDName(
                userItemInputDto.userId,
                userItemInputDto.userName
            )
        )
                ).rentItem(Item(userItemInputDto.itemId, userItemInputDto.itemTitle))
        val savedRentalCard = rentalCardOutputPort.save(rentalCard)
        return RentalCardOutputDto.mapToDto(savedRentalCard)


    }
}