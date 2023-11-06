package kr.jay.book.framework.jpaadapter

import kr.jay.book.domain.model.Book
import org.springframework.data.jpa.repository.JpaRepository

/**
 * BookRepository
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface BookRepository : JpaRepository<Book, Long>{
}