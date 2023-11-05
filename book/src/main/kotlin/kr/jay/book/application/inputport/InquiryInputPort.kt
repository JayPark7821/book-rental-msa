package kr.jay.book.application.inputport

import kr.jay.book.application.outputport.BookOutPutPort
import kr.jay.book.application.usecase.InquiryUseCase
import kr.jay.book.application.usecase.dto.BookOutPutDto
import org.springframework.stereotype.Service

/**
 * InquiryInpuPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@Service
class InquiryInputPort(
    private val bookOutPutPort: BookOutPutPort,
) : InquiryUseCase {
    override fun getBookInfo(bookNo: Long) = BookOutPutDto.mapToDto(bookOutPutPort.loadBook(bookNo))

}