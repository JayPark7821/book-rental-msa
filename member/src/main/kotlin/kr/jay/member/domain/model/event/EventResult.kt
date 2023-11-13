package kr.jay.member.domain.model.event

import kr.jay.member.domain.model.vo.IdName

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