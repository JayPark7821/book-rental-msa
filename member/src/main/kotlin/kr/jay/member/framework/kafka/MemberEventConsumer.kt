package kr.jay.member.framework.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import kr.jay.member.application.usecase.SavePointUseCase
import kr.jay.member.application.usecase.UsePointUseCase
import kr.jay.member.domain.model.event.ItemRented
import kr.jay.member.domain.model.event.ItemReturned
import kr.jay.member.domain.model.event.OverdueCleared
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component
class MemberEventConsumer(
    private val objectMapper: ObjectMapper,
    private val savePointUseCase: SavePointUseCase,
    private val usePointUseCase: UsePointUseCase,
    ) {

    @KafkaListener(topics = ["\${consumers.topic1.name}"], groupId = "\${consumers.group-id}")
    fun consumeRental(record: ConsumerRecord<String, String>){
        println("rental record.value() = ${record.value()}")
        val itemRented = objectMapper.readValue<ItemRented>(record.value(), ItemRented::class.java)
        savePointUseCase.savePoint(idName = itemRented.idName, point = itemRented.point)
    }

    @KafkaListener(topics = ["\${consumers.topic2.name}"], groupId = "\${consumers.group-id}")
    fun consumeReturn(record: ConsumerRecord<String, String>){
        println("return record.value() = ${record.value()}")
        val itemReturn = objectMapper.readValue<ItemReturned>(record.value(), ItemReturned::class.java)
        savePointUseCase.savePoint(idName = itemReturn.idName, point = itemReturn.point)
    }

    @KafkaListener(topics = ["\${consumers.topic3.name}"], groupId = "\${consumers.group-id}")
    fun consumeOverdueClear(record: ConsumerRecord<String, String>){
        println("overdue record.value() = ${record.value()}")
        val overdueCleared = objectMapper.readValue<OverdueCleared>(record.value(), OverdueCleared::class.java)
        usePointUseCase.usePoint(idName = overdueCleared.idName, point = overdueCleared.point)
    }
}