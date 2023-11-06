package kr.jay.book.domain.model.vo

import jakarta.persistence.Embeddable
import java.time.LocalDate

/**
 * BookDesc
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/5/23
 */

@Embeddable
data class BookDesc private constructor(
    val description: String,
    val author: String,
    val isbn: String,
    val publisherDate: LocalDate,
    val source: Source,
) {
    companion object {
        fun createBookDesc(
            description: String,
            author: String,
            isbn: String,
            publisherDate: LocalDate,
            source: Source,
        ) =
            BookDesc(
                description = description,
                author = author,
                isbn = isbn,
                publisherDate = publisherDate,
                source = source,
            )


    }

}
