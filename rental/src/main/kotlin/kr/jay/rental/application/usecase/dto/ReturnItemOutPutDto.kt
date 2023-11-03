package kr.jay.rental.application.usecase.dto

import kr.jay.rental.domain.model.vo.ReturnItem
import java.time.LocalDate

/**
 * ReturnItemOutPutDto
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
data class ReturnItemOutPutDto(
    val itemNo: Int,
    val itemTitle: String,
    val returnDate: LocalDate,
){
    companion object{
        fun mapToDto(returnItem: ReturnItem) = ReturnItemOutPutDto(
            itemNo = returnItem.rentalItem.item.no,
            itemTitle = returnItem.rentalItem.item.title,
            returnDate = returnItem.returnDate
        )
    }
}
