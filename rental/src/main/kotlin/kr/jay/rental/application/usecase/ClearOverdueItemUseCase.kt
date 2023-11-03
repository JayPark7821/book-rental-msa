package kr.jay.rental.application.usecase

import kr.jay.rental.application.usecase.dto.ClearOverdueInfoDto
import kr.jay.rental.application.usecase.dto.RentalResultOutputDto

/**
 * ClearOverdueItemUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
interface ClearOverdueItemUseCase {
    fun clearOverdue(clearOverdueInfoDto : ClearOverdueInfoDto): RentalResultOutputDto
}