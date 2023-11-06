package kr.jay.member.domain.model.vo

import jakarta.persistence.Embeddable

/**
 * Point
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
@Embeddable
data class Point private constructor(
    val point: Long,
) {
    companion object {
        fun createPoint() = Point(0L)
    }

    fun addPoint(point: Long): Point {
        return Point(this.point + point)
    }

    fun usePoint(point: Long): Point {
        if (this.point < point) throw IllegalArgumentException("포인트가 부족합니다.")
        return Point(this.point - point)
    }
}
