package kr.jay.rental.application.usecase

import kr.jay.rental.application.usecase.dto.RentalCardOutputDto
import kr.jay.rental.application.usecase.dto.RentalItemOutputDto
import kr.jay.rental.application.usecase.dto.ReturnItemOutPutDto
import kr.jay.rental.application.usecase.dto.UserInputDto

/**
 * InquiryUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
interface InquiryUseCase {

    fun getRentalCard(userInputDto: UserInputDto): RentalCardOutputDto?
    fun getAllRentItem(userInputDto: UserInputDto): List<RentalItemOutputDto>?
    fun getAllReturnItem(userInputDto: UserInputDto): List<ReturnItemOutPutDto>?
}