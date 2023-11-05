package kr.jay.book.application.usecase

import kr.jay.book.application.usecase.dto.BookInfoDto
import kr.jay.book.application.usecase.dto.BookOutPutDto

/**
 * AddBookUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/5/23
 */
interface AddBookUseCase {
    fun addBook(bookInfoDto: BookInfoDto): BookOutPutDto
}