package kr.jay.book.framework.kafka

import kr.jay.book.domain.model.event.EventResult
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

/**
 * BookEventProducer
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/13/23
 */
@Component
class BookEventProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
) {
    @Value("\${producers.topic1.name}")
    private lateinit var TOPIC_RENT: String;

    fun occurEvent(eventResult: EventResult) {
        val future = kafkaTemplate.send(TOPIC_RENT, eventResult)
        future.whenComplete() { result, exception ->
            if (exception != null) {
                println("Exception Occurred")
            } else {
                println("Success")
            }
        }
    }

}