package kr.jay.book.domain.model

import kr.jay.book.domain.model.vo.*
import java.time.LocalDate

/**
 * Book
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/5/23
 */
class Book(
    no: Long,
    title: String,
    desc: BookDesc,
    classification: Classification,
    bookStatus: BookStatus,
    location: Location,
) {


    var no = no
        private set
    var title = title
        private set
    var desc = desc
        private set
    var classification = classification
        private set
    var bookStatus = bookStatus
        private set
    var location = location
        private set

    companion object {
        fun enterBook(
            title: String,
            author: String,
            isbn: String,
            description: String,
            publicationDate: LocalDate,
            source :Source,
            classification: Classification,
            location: Location,
            ) : Book{
            val bookDesc = BookDesc.createBookDesc(
                description = description,
                author = author,
                isbn = isbn,
                publisherDate = publicationDate,
                source = source
            )
            return Book(
                no = 0,
                title = title,
                desc = bookDesc,
                classification = classification,
                location = location,
                bookStatus = BookStatus.ENTERED
            )
        }
    }

    fun makeAvailable() : Book{
        this.bookStatus = BookStatus.AVAILABLE
        return this
    }

    fun makeUnAvailable() : Book{
        this.bookStatus = BookStatus.UNAVAILABLE
        return this
    }


}