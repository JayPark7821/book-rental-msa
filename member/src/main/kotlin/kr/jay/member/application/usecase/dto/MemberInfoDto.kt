package kr.jay.member.application.usecase.dto

/**
 * MemberInfoDto
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
data class MemberInfoDto(
    val id: String,
    val name: String,
    val passPwd: String,
    val address: String,
)
