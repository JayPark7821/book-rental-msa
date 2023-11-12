package kr.jay.book.framework.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import kr.jay.book.application.usecase.MakeAvailableUseCase
import kr.jay.book.application.usecase.MakeUnAvailableUseCase
import kr.jay.book.domain.model.event.ItemRented
import kr.jay.book.domain.model.event.ItemReturned
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

/**
 * BookEventConsumer
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/9/23
 */

@Component
class BookEventConsumer(
    private val objectMapper: ObjectMapper,
    private val makeAvailableUseCase: MakeAvailableUseCase,
    private val makeUnAvailableUseCase: MakeUnAvailableUseCase,
    ) {

    @KafkaListener(topics = ["\${consumers.topic1.name}"], groupId = "\${consumers.group-id}")
    fun consumeRental(record: ConsumerRecord<String, String>){
        println("rental record.value() = ${record.value()}")
        val itemRented = objectMapper.readValue<ItemRented>(record.value(), ItemRented::class.java)
        makeUnAvailableUseCase.unAvailable(itemRented.item.no.toLong())
    }

    @KafkaListener(topics = ["\${consumers.topic2.name}"], groupId = "\${consumers.group-id}")
    fun consumeReturn(record: ConsumerRecord<String, String>){
        println("return record.value() = ${record.value()}")
        val itemReturn = objectMapper.readValue<ItemReturned>(record.value(), ItemReturned::class.java)
        makeAvailableUseCase.available(itemReturn.item.no.toLong())
    }
}