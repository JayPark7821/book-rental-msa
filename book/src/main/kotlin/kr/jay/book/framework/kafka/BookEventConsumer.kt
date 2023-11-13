package kr.jay.book.framework.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import kr.jay.book.application.usecase.MakeAvailableUseCase
import kr.jay.book.application.usecase.MakeUnAvailableUseCase
import kr.jay.book.domain.model.event.*
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
    private val eventProducer: BookEventProducer,
    ) {


    @KafkaListener(topics = ["\${consumers.topic1.name}"], groupId = "\${consumers.group-id}")
    fun consumeRental(record: ConsumerRecord<String, String>){
        println("rental record.value() = ${record.value()}")
        val itemRented = objectMapper.readValue<ItemRented>(record.value(), ItemRented::class.java)

        eventProducer.occurEvent(
            try {
                makeUnAvailableUseCase.unAvailable(itemRented.item.no.toLong())
                EventResult(
                    eventType = EventType.RENT,
                    isSucceed = true,
                    idName = itemRented.idName,
                    item = itemRented.item,
                    point = itemRented.point
                )
            } catch (e: Exception) {
                println("e = ${e.message}")
                EventResult(
                    eventType = EventType.RENT,
                    isSucceed = true,
                    idName = itemRented.idName,
                    item = itemRented.item,
                    point = itemRented.point
                )
            }
        )
    }

    @KafkaListener(topics = ["\${consumers.topic2.name}"], groupId = "\${consumers.group-id}")
    fun consumeReturn(record: ConsumerRecord<String, String>){
        println("return record.value() = ${record.value()}")
        val itemRented = objectMapper.readValue<ItemRented>(record.value(), ItemRented::class.java)

        eventProducer.occurEvent(
            try {
                makeAvailableUseCase.available(itemRented.item.no.toLong())
                EventResult(
                    eventType = EventType.RETURN,
                    isSucceed = true,
                    idName = itemRented.idName,
                    item = itemRented.item,
                    point = itemRented.point
                )
            } catch (e: Exception) {
                println("e = ${e.message}")
                EventResult(
                    eventType = EventType.RETURN,
                    isSucceed = true,
                    idName = itemRented.idName,
                    item = itemRented.item,
                    point = itemRented.point
                )
            }
        )
    }
}