package kr.jay.rental.framework.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import kr.jay.rental.application.usecase.CompensationUseCase
import kr.jay.rental.domain.event.EventResult
import kr.jay.rental.domain.event.EventType
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

/**
 * RentalEventConsumers
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/13/23
 */
@Component
class RentalEventConsumers(
    private val objectMapper: ObjectMapper,
    private val compensationUseCase: CompensationUseCase,
) {


    @KafkaListener(topics = ["\${consumers.topic1.name}"], groupId = "\${consumers.group-id}")
    fun consumeRental(record: ConsumerRecord<String, String>){
        println("rental record.value() = ${record.value()}")
        val eventResult = objectMapper.readValue<EventResult>(record.value(), EventResult::class.java)

        if(!eventResult.isSucceed){
            val eventType = eventResult.eventType
            when (eventType){
                EventType.RENT -> compensationUseCase.cancelRentItem(eventResult.idName , eventResult.item)
                EventType.RETURN -> compensationUseCase.cancelReturnItem(eventResult.idName , eventResult.item, eventResult.point)
                EventType.OVERDUE -> compensationUseCase.cancelMakeAvailableRental(eventResult.idName, eventResult.point)
            }

        }

    }
}