package com.prasant.producer;

import com.prasant.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequiredArgsConstructor
public class KafkaJsonProducer {

	private final KafkaTemplate<String, Student> kafkaTemplate;

	public void sendMessage(Student student){
		log.info("Sending message to objects Topic :: {}", student.toString());

		Message<Student> message = MessageBuilder
				.withPayload(student)
				.setHeader(KafkaHeaders.TOPIC, "objects")
				.build();

		kafkaTemplate.send(message);
	}
}
