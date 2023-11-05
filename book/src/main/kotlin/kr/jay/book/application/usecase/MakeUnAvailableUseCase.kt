package kr.jay.book.application.usecase

import kr.jay.book.application.usecase.dto.BookOutPutDto

/**
 * MakeUnAvailableUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface MakeUnAvailableUseCase {
    fun unAvailable(bookNo: Long): BookOutPutDto
}