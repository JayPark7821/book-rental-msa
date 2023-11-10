package kr.jay.bestbook.persistence

import kr.jay.bestbook.domain.model.BestBook
import kr.jay.bestbook.domain.model.Item
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * BestBookRepository
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface BestBookRepository
    : MongoRepository<BestBook, String>
{
    fun findBestBookByItem(item: Item): BestBook?

}

