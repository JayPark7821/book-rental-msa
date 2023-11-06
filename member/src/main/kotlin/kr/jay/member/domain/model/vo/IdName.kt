package kr.jay.member.domain.model.vo

import jakarta.persistence.Embeddable

/**
 * IdName
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
@Embeddable
data class IdName(
    val id: String,
    val name: String,
)

