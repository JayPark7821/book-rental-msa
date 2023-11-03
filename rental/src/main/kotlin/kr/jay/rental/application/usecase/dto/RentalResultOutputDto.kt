package kr.jay.rental.application.usecase.dto

import kr.jay.rental.domain.model.RentalCard

/**
 * RentalResultOutputDto
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
data class RentalResultOutputDto(
    val userId: String,
    val userName: String,
    val rentedCount : Int,
    val totalLateFee : Long,
){
    companion object {
        fun mapToDto(rental: RentalCard) =
            RentalResultOutputDto(
                userId = rental.member.id,
                userName = rental.member.name,
                rentedCount = rental.rentalItemList.count(),
                totalLateFee = rental.lateFee.point
            )
    }
}
