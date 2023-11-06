package kr.jay.book.framework.jpaadapter

import kr.jay.book.application.outputport.BookOutPutPort
import kr.jay.book.domain.model.Book
import org.springframework.stereotype.Repository

/**
 * BookAdapter
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@Repository
class BookAdapter(
  private val bookRepository: BookRepository
) : BookOutPutPort{
    override fun loadBook(bookNo: Long) : Book
    = bookRepository.findById(bookNo).orElseThrow()

    override fun saveBook(book: Book): Book
    = bookRepository.save(book)
}