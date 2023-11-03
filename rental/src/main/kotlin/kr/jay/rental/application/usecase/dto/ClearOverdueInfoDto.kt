package kr.jay.rental.application.usecase.dto

/**
 * ClearOverdueInfoDto
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
data class ClearOverdueInfoDto(
    val userId: String,
    val userName: String,
    val point: Long,
)
