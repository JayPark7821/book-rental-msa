package kr.jay.rental.application.usecase

import kr.jay.rental.application.usecase.dto.RentalCardOutputDto
import kr.jay.rental.application.usecase.dto.UserItemInputDto

/**
 * ReturnItemUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
interface ReturnItemUseCase {
    fun returnItem(userItemInputDto: UserItemInputDto) : RentalCardOutputDto
}