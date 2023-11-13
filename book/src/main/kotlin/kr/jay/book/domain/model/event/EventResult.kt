package kr.jay.book.domain.model.event

/**
 * EventResult
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/12/23
 */
data class EventResult(
    private val eventType: EventType,
    private val isSucceed: Boolean,
    private val idName: IdName,
    private val item: Item,
    private val point: Long,
    ) {
}