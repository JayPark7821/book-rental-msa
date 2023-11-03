package kr.jay.rental.application.usecase

import kr.jay.rental.application.usecase.dto.RentalCardOutputDto
import kr.jay.rental.application.usecase.dto.UserItemInputDto

/**
 * OverdueItemUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
interface OverdueItemUseCase {
    fun overdueItem(userItemInputDto: UserItemInputDto) : RentalCardOutputDto
}