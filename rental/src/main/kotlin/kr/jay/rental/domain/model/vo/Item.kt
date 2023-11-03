package kr.jay.rental.domain.model.vo

import jakarta.persistence.Embeddable

@Embeddable
data class Item  (
     val no: Int,
     val title: String,
)