package kr.jay.member.domain.model.vo

import jakarta.persistence.Embeddable

/**
 * PassWord
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
@Embeddable
data class PassWord(
    val presentPwd: String,
    val pastPwd: String,
)
