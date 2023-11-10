package kr.jay.rental.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import kotlin.String as String

/**
 * KafkaConfig
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/9/23
 */

@Configuration
class KafkaConfig {

    @Value("\${producers.bootstrap-servers}")
    private lateinit var bootstrapServer:String

    @Bean
    fun producerFactory(): ProducerFactory<String, Any> {
        return DefaultKafkaProducerFactory(
            mapOf<String, String>(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServer,
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.name,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java.name
            )
        )
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Any> {
        return KafkaTemplate(producerFactory())
    }
}