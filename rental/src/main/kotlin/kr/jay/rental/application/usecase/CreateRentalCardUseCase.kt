package kr.jay.rental.application.usecase

import kr.jay.rental.application.usecase.dto.RentalCardOutputDto
import kr.jay.rental.application.usecase.dto.UserInputDto

/**
 * CreateRentalCardUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
interface CreateRentalCardUseCase {
    fun createRentalCard(userInputDto: UserInputDto) : RentalCardOutputDto
}