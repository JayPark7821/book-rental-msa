package kr.jay.rental.domain.model.vo

import jakarta.persistence.Embeddable
import java.io.Serializable
import java.time.LocalDate
import java.util.*

@Embeddable
data class  RentalCardNo private constructor(
    val no: String,
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
