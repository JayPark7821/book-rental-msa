package kr.jay.book.application.usecase.dto

import kr.jay.book.domain.model.Book

/**
 * BookOutPutDto
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/5/23
 */
data class BookOutPutDto(
    val bookNo: Long,
    val bookTitle: String,
    val bookStatus: String,
) {
    companion object {
        fun mapToDto(book: Book) = BookOutPutDto(
            bookNo = book.no,
            bookTitle = book.title,
            bookStatus = book.bookStatus.name,
        )

    }
}
