package kr.jay.book.framework.web

import kr.jay.book.application.usecase.AddBookUseCase
import kr.jay.book.application.usecase.InquiryUseCase
import kr.jay.book.application.usecase.dto.BookInfoDto
import kr.jay.book.application.usecase.dto.BookOutPutDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * BookController
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@RestController
@RequestMapping("/api")
class BookController(
    private val addBookUseCase: AddBookUseCase,
    private val inquiryUseCase: InquiryUseCase,
) {

    @PostMapping("/book")
    fun createBook(@RequestBody bookInfoDto: BookInfoDto) =
        ResponseEntity(addBookUseCase.addBook(bookInfoDto), HttpStatus.OK)


    @GetMapping("/book/{no}")
    fun getBook(@PathVariable("no") bookNo: Long) =
        ResponseEntity(inquiryUseCase.getBookInfo(bookNo), HttpStatus.OK)

}