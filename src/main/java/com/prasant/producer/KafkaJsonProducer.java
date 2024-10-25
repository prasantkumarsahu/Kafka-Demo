package com.prasant.producer;

import com.prasant.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Author: Prasant
 * Date: 25/10/24
 */

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

	private final KafkaTemplate<String, Student> kafkaTemplate;

	public void sendMessage(Student student){
		Message<Student> message = MessageBuilder
				.withPayload(student)
				.setHeader(KafkaHeaders.TOPIC, "prasant")
				.build();

		kafkaTemplate.send(message);
	}
}
