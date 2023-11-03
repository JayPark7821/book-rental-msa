package kr.jay.rental.domain.model.vo

import jakarta.persistence.Embeddable

@Embeddable
data class LateFee private constructor(
    val point: Long
) {
    companion object{
        fun createLateFee() : LateFee{
            return LateFee(0)
        }
    }

    fun addPoint(point: Long) =
        this.copy(point = this.point + point)

    fun removePoint(point: Long) : LateFee{
        if(this.point < point) {
            throw IllegalArgumentException("포인트가 부족합니다.")
        }
        return this.copy(point = this.point - point)
    }
}
