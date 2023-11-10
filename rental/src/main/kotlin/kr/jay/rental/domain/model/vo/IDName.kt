package kr.jay.rental.domain.model.vo

import jakarta.persistence.Embeddable

@Embeddable
data class IdName (

    val id: String,
    val name: String,
)