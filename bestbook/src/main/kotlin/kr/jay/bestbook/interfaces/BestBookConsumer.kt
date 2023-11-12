package kr.jay.bestbook.interfaces

import com.fasterxml.jackson.databind.ObjectMapper
import kr.jay.bestbook.domain.BestBookService
import kr.jay.bestbook.domain.model.ItemRented
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

/**
 * BestBookConsumer
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/9/23
 */

@Component
class BestBookConsumer(
    private val objectMapper: ObjectMapper,
    private val bestBookService: BestBookService,
) {
    @KafkaListener(topics = ["\${consumers.topic1.name}"], groupId = "\${consumers.group-id}")
    fun consumeRental(record: ConsumerRecord<String, String>){
        println("rental record.value() = ${record.value()}")
        val itemRented = objectMapper.readValue<ItemRented>(record.value(), ItemRented::class.java)
        bestBookService.dealBestBook(itemRented.item)
    }
}