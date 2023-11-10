package kr.jay.rental.domain.event

import kr.jay.rental.domain.model.vo.IdName
import kr.jay.rental.domain.model.vo.Item

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
