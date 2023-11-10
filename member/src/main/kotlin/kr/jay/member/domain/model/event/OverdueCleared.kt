package kr.jay.member.domain.model.event

import jakarta.persistence.Id
import kr.jay.member.domain.model.vo.IdName

data class OverdueCleared(
    val idName: IdName,
    val point: Long,
)