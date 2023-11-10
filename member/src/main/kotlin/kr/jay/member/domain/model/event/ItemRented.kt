package kr.jay.member.domain.model.event

import kr.jay.member.domain.model.vo.IdName

/**
 * ItemRented
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/9/23
 */
data class ItemRented(
    val idName: IdName,
    val item: Item,
    val point: Long,
)
