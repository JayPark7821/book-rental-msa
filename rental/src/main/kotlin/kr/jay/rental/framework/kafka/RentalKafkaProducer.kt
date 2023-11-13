package kr.jay.rental.framework.kafka

import kr.jay.rental.application.outputport.EventOutputPort
import kr.jay.rental.domain.event.ItemRented
import kr.jay.rental.domain.event.ItemReturned
import kr.jay.rental.domain.event.OverdueCleared
import kr.jay.rental.domain.event.PointUseCommand
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component

/**
 * RentalKafkaProducer
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/9/23
 */
@Component
class RentalKafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
): EventOutputPort {

    @Value("\${producers.topic1.name}")
    private lateinit var TOPIC_RENT: String;

    @Value("\${producers.topic2.name}")
    private lateinit var TOPIC_RETURN: String;

    @Value("\${producers.topic3.name}")
    private lateinit var TOPIC_OVERDUE_CLEAR: String;
    @Value("\${producers.topic4.name}")
    private lateinit var TOPIC_POINT: String;
    override fun occurRentalEvent(itemRented: ItemRented) {
        val future = kafkaTemplate.send(TOPIC_RENT, itemRented)
        future.whenComplete() { result, exception ->
            if (exception != null) {
                println("Exception Occurred")
            } else {
                println("Success")
            }
        }
    }

    override fun occurReturnEvent(itemReturned: ItemReturned) {
        val future = kafkaTemplate.send(TOPIC_RETURN, itemReturned)
        future.whenComplete() { result, exception ->
            if (exception != null) {
                println("Exception Occurred")
            } else {
                println("Success")
            }
        }
    }

    override fun occurOverdueClearedEvent(overdueCleared: OverdueCleared) {
        val future = kafkaTemplate.send(TOPIC_OVERDUE_CLEAR, overdueCleared)
        future.whenComplete() { result, exception ->
            if (exception != null) {
                println("Exception Occurred")
            } else {
                println("Success")
            }
        }
    }

    override fun occurPointUseCommand(pointUseCommand: PointUseCommand) {
        val future = kafkaTemplate.send(TOPIC_POINT, pointUseCommand)
        future.whenComplete() { result, exception ->
            if (exception != null) {
                println("Exception Occurred")
            } else {
                println("Success")
            }
        }
    }
}