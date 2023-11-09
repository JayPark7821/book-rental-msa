package kr.jay.bestbook.domain

import kr.jay.bestbook.domain.model.BestBook
import kr.jay.bestbook.domain.model.Item
import kr.jay.bestbook.persistence.BestBookRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

/**
 * BestBookService
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@Service
class BestBookService(
    private val bestBookRepository: BestBookRepository,
) {
    fun getAllBooks(): List<BestBook> = bestBookRepository.findAll()

    fun getBookById(id: String): BestBook = bestBookRepository.findById(id).orElseThrow()

    fun dealBestBook(item: Item){
        bestBookRepository.findBestBookByItem(item)
            ?.let{
                it.increaseRentCount()
                bestBookRepository.save(it)
            }
            ?:bestBookRepository.save(BestBook.registerBestBook(item))
    }

    fun deleteBook(id: String){
        bestBookRepository.findByIdOrNull(id)
            ?.let{
                bestBookRepository.delete(it)
            }
    }

    fun saveBook(book: BestBook): BestBook = bestBookRepository.save(book)

    fun updateBook(id: String, book: BestBook): BestBook{
        return bestBookRepository.findByIdOrNull(id)
            ?.let{
                it.item = book.item
                it.rentCount = book.rentCount
                bestBookRepository.save(it)
            }?: throw Exception("Not Found")
    }
}