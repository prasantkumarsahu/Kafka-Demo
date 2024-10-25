package com.prasant.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Author: Prasant
 * Date: 25/10/24
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String msg){
		log.info("Sending message to prasant Topic :: {}", msg);

		kafkaTemplate.send("prasant", msg);
	}
}
