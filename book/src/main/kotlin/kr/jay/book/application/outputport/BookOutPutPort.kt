package kr.jay.book.application.outputport

import kr.jay.book.domain.model.Book

/**
 * BookOutPutPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/5/23
 */
interface BookOutPutPort {
    fun loadBook(bookNo: Long): Book
    fun saveBook(book: Book): Book
}