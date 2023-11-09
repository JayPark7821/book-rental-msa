package kr.jay.bestbook.domain.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

/**
 * BestBook
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
@Document
class BestBook(
    id: String,
    var item: Item,
    var rentCount: Long,
) {

    companion object {
        fun registerBestBook(
            item: Item,
        ) = BestBook(
            id = UUID.randomUUID().toString(),
            item = item,
            rentCount = 1L
        )
    }

    fun increaseRentCount() = rentCount++

    @Id
    var id = id
        private set


}