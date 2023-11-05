package kr.jay.book.application.inputport

import kr.jay.book.application.outputport.BookOutPutPort
import kr.jay.book.application.usecase.MakeAvailableUseCase
import kr.jay.book.application.usecase.dto.BookOutPutDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * MakeAvailableInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@Service
@Transactional
class MakeAvailableInputPort(
    private val bookOutPutPort: BookOutPutPort
): MakeAvailableUseCase {
    override fun available(bookNo: Long): BookOutPutDto {
        bookOutPutPort.loadBook(bookNo).let {
            it.makeAvailable()
            bookOutPutPort.saveBook(it)
            return BookOutPutDto.mapToDto(it)
        }
    }

}