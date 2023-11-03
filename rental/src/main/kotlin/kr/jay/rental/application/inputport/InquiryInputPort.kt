package kr.jay.rental.application.inputport

import kr.jay.rental.application.outputport.RentalCardOutputPort
import kr.jay.rental.application.usecase.InquiryUseCase
import kr.jay.rental.application.usecase.dto.RentalCardOutputDto
import kr.jay.rental.application.usecase.dto.RentalItemOutputDto
import kr.jay.rental.application.usecase.dto.ReturnItemOutPutDto
import kr.jay.rental.application.usecase.dto.UserInputDto
import org.springframework.stereotype.Service

/**
 * InquiryInpuPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
@Service
class InquiryInputPort(
    private val rentalCardOutputPort: RentalCardOutputPort,
) : InquiryUseCase {

    override fun getRentalCard(userInputDto: UserInputDto): RentalCardOutputDto? {
        return rentalCardOutputPort.loadRentalCard(userInputDto.userId)?.let {
            RentalCardOutputDto.mapToDto(it)
        }
    }

    override fun getAllRentItem(userInputDto: UserInputDto): List<RentalItemOutputDto>? {
        return rentalCardOutputPort.loadRentalCard(userInputDto.userId)?.rentalItemList?.map { rentalItem ->
            RentalItemOutputDto.mapToDto(rentalItem)
        }?.toList()
    }

    override fun getAllReturnItem(userInputDto: UserInputDto): List<ReturnItemOutPutDto>? {
        return rentalCardOutputPort.loadRentalCard(userInputDto.userId)?.returnItemList?.map {
            ReturnItemOutPutDto.mapToDto(it)
        }?.toList()
    }
}
