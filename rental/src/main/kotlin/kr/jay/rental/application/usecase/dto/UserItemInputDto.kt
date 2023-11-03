package kr.jay.rental.application.usecase.dto

/**
 * UserItemInputDto
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
data class UserItemInputDto(
    val userId: String,
    val userName: String,
    val itemId: Int,
    val itemTitle: String,
)
