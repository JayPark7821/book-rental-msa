package kr.jay.book.application.usecase

import kr.jay.book.application.usecase.dto.BookOutPutDto

/**
 * InquiryUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface InquiryUseCase {
    fun getBookInfo(bookNo: Long): BookOutPutDto
}