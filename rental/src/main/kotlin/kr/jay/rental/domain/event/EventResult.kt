package kr.jay.rental.domain.event

import kr.jay.rental.domain.model.vo.IdName
import kr.jay.rental.domain.model.vo.Item

/**
 * EventResult
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/12/23
 */
data class EventResult(
    val eventType: EventType,
    val isSucceed: Boolean,
    val idName: IdName,
    val item: Item,
    val point: Long,
    ) {
}