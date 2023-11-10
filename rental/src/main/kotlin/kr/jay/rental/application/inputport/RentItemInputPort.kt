package kr.jay.rental.application.inputport

import kr.jay.rental.application.outputport.EventOutputPort
import kr.jay.rental.application.outputport.RentalCardOutputPort
import kr.jay.rental.application.usecase.RentItemUseCase
import kr.jay.rental.application.usecase.dto.RentalCardOutputDto
import kr.jay.rental.application.usecase.dto.UserItemInputDto
import kr.jay.rental.domain.model.RentalCard
import kr.jay.rental.domain.model.vo.IdName
import kr.jay.rental.domain.model.vo.Item
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RentItemInputPort(
    private val rentalCardOutputPort: RentalCardOutputPort,
    private val eventOutputPort: EventOutputPort,
) : RentItemUseCase {

    override fun rentItem(userItemInputDto: UserItemInputDto): RentalCardOutputDto {
        val rentedItem = Item(userItemInputDto.itemId, userItemInputDto.itemTitle)
        val rentalCard = (rentalCardOutputPort.loadRentalCard(userItemInputDto.userId) ?: RentalCard.createRentalCard(
            IdName(
                userItemInputDto.userId,
                userItemInputDto.userName
            )
        )
                ).rentItem(rentedItem)
        val savedRentalCard = rentalCardOutputPort.save(rentalCard)

        eventOutputPort.occurRentalEvent(
            RentalCard.createItemRentedEvent(
                idName = rentalCard.member,
                item = rentedItem,
                point = 10L
            )
        )
        return RentalCardOutputDto.mapToDto(savedRentalCard)


    }
}