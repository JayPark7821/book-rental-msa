package kr.jay.book.application.inputport

import kr.jay.book.application.outputport.BookOutPutPort
import kr.jay.book.application.usecase.MakeUnAvailableUseCase
import kr.jay.book.application.usecase.dto.BookOutPutDto
import org.springframework.stereotype.Component

/**
 * MakeUnAvailableInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@Component
class MakeUnAvailableInputPort(
    private val bookOutPutPort: BookOutPutPort,
) : MakeUnAvailableUseCase {
    override fun unAvailable(bookNo: Long): BookOutPutDto {
        bookOutPutPort.loadBook(bookNo).let {
            it.makeUnAvailable()
            bookOutPutPort.saveBook(it)
            return BookOutPutDto.mapToDto(it)
        }
    }
}