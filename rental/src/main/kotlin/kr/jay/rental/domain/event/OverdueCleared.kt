package kr.jay.rental.domain.event

import kr.jay.rental.domain.model.vo.IdName

/**
 * OverdueCleared
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/9/23
 */
data class OverdueCleared(
    val idName: IdName,
    val point: Long,
)