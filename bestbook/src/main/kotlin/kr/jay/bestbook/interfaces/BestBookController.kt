package kr.jay.bestbook.interfaces

import kr.jay.bestbook.domain.BestBookService
import kr.jay.bestbook.domain.model.BestBook
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * BestBookController
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
@RestController
@RequestMapping("/api")
class BestBookController(
    private val bestBookService: BestBookService,
) {
    @GetMapping("/books")
    fun getAllBooks(): ResponseEntity<List<BestBook>> {
        return ResponseEntity(bestBookService.getAllBooks(), HttpStatus.OK)
    }

    @GetMapping("/books/{id}")
    fun getBookById(@PathVariable("id") id : String) : ResponseEntity<BestBook> =
        ResponseEntity(bestBookService.getBookById(id), HttpStatus.OK)


    @PostMapping("/books")
    fun createBook(@RequestBody  book : BestBook): ResponseEntity<BestBook>
    = ResponseEntity(bestBookService.saveBook(book), HttpStatus.CREATED)


    @PutMapping("/books/{id}")
    fun updateBook(
        @PathVariable("id") id: String,
        @RequestBody book: BestBook,
    ):ResponseEntity<BestBook>
    = ResponseEntity(bestBookService.updateBook(id, book), HttpStatus.OK)
}