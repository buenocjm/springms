package com.taller.notificationsms.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.annotation.EnableKafka;
import com.taller.notificationsms.events.Event;


@EnableKafka
@Configuration
public class NotifiConfig {
	private final String bootstrapAddress = "localhost:9092";

    @Bean
    public ConsumerFactory<String, Event<?>> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(JsonSerializer.TYPE_MAPPINGS,"com.taller:com.taller.notificationsms.events.Event");

		
		  final JsonDeserializer<Event<?>> jsonDeserializer = new JsonDeserializer<>();
		  return new DefaultKafkaConsumerFactory( props, new StringDeserializer(),
		  jsonDeserializer);
		    
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Event<?>>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Event<?>> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}

