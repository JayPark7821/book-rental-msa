package kr.jay.rental.domain.model.vo

import java.time.LocalDate
import java.util.*

data class  RentalCardNo private constructor(
    private val no: String,
){
    companion object{
        fun createRentalCardNo() : RentalCardNo{
            val uuid = UUID.randomUUID()
            val year = LocalDate.now().year.toString()
            val rentalCardNo = "$year-$uuid"
            return RentalCardNo(rentalCardNo)
        }
    }
}
