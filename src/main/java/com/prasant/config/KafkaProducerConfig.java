package com.prasant.config;

import com.prasant.payload.Student;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Prasant
 * Date: 04/11/24
 */

@Configuration
public class KafkaProducerConfig {

	// KafkaTemplate for JSON serialization (e.g., for Student objects)
	@Bean
	public KafkaTemplate<String, Student> jsonKafkaTemplate(){
		Map<String, Object> producerProps = new HashMap<>();
		producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
		producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		ProducerFactory<String, Student> producerFactory = new DefaultKafkaProducerFactory<>(producerProps);
		return new KafkaTemplate<>(producerFactory);
	}

	// KafkaTemplate for String serialization
	@Bean
	public KafkaTemplate<String, String> stringKafkaTemplate(){
		Map<String, Object> producerProps = new HashMap<>();
		producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
		producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(producerProps);
		return new KafkaTemplate<>(producerFactory);
	}
}
