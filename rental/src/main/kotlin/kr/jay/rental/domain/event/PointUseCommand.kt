package kr.jay.rental.domain.event

import kr.jay.rental.domain.model.vo.IdName

/**
 * PointUseCommand
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/13/23
 */
data class PointUseCommand(
    val idName: IdName,
    val point: Long,
)
