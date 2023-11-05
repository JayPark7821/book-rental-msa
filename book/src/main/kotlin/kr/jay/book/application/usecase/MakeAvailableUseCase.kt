package kr.jay.book.application.usecase

import kr.jay.book.application.usecase.dto.BookOutPutDto

/**
 * MakeAvailableUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface MakeAvailableUseCase {
    fun available(bookNo: Long): BookOutPutDto
}