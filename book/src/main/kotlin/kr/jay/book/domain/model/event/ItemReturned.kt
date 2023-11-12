package kr.jay.book.domain.model.event

/**
 * ItemReturned
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/9/23
 */
data class ItemReturned(
    val idName: IdName,
    val item: Item,
    val point: Long,
)
