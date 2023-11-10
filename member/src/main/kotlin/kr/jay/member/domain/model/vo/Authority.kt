package kr.jay.member.domain.model.vo

import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

/**
 * Authority
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
@Embeddable
data class Authority(
    @Enumerated(EnumType.STRING)
    private val authority: UserRole,
)
