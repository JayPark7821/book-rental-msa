package kr.jay.rental.domain.model.vo

data class LateFee private constructor(
    private val point: Long
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
