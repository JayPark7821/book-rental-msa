package kr.jay.book.application.inputport

import kr.jay.book.application.outputport.BookOutPutPort
import kr.jay.book.application.usecase.AddBookUseCase
import kr.jay.book.application.usecase.dto.BookInfoDto
import kr.jay.book.application.usecase.dto.BookOutPutDto
import kr.jay.book.domain.model.Book
import kr.jay.book.domain.model.vo.Classification
import kr.jay.book.domain.model.vo.Location
import kr.jay.book.domain.model.vo.Source
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * AddBookInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/5/23
 */
@Transactional
@Service
class AddBookInputPort(
    private val bookOutPutPort: BookOutPutPort
): AddBookUseCase {

    override fun addBook(bookInfoDto: BookInfoDto): BookOutPutDto {
        Book.enterBook(
            title = bookInfoDto.title,
            description = bookInfoDto.description,
            author = bookInfoDto.author,
            isbn = bookInfoDto.isbn,
            publicationDate = bookInfoDto.publicationDate,
            source = Source.valueOf(bookInfoDto.source),
            classification = Classification.valueOf(bookInfoDto.classification),
            location = Location.valueOf(bookInfoDto.location),
        ).let {
            bookOutPutPort.saveBook(it)
            return BookOutPutDto.mapToDto(it)
        }
    }
}