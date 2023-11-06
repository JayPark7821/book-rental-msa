package kr.jay.member.domain.model.vo

import jakarta.persistence.Embeddable

/**
 * Authority
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
@Embeddable
data class Authority(
    private val authority: UserRole,
)
