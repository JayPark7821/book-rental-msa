package kr.jay.rental.application.inputport

import kr.jay.rental.application.outputport.RentalCardOutputPort
import kr.jay.rental.application.usecase.ReturnItemUseCase
import kr.jay.rental.application.usecase.dto.RentalCardOutputDto
import kr.jay.rental.application.usecase.dto.UserItemInputDto
import kr.jay.rental.domain.model.vo.Item
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException
import java.time.LocalDate

/**
 * ReturnItemInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */

@Service
@Transactional
class ReturnItemInputPort(
    private val rentalCardOutputPort: RentalCardOutputPort
) : ReturnItemUseCase {

    override fun returnItem(userItemInputDto: UserItemInputDto): RentalCardOutputDto {
        val rentalCard = rentalCardOutputPort.loadRentalCard(userItemInputDto.userId) ?: throw IllegalArgumentException(
            "대여카드가 존재하지 않습니다."
        )

        val returnItem =
            rentalCard.returnItem(Item(userItemInputDto.itemId, userItemInputDto.itemTitle), LocalDate.now())
        return RentalCardOutputDto.mapToDto(rentalCardOutputPort.save(returnItem))
    }
}