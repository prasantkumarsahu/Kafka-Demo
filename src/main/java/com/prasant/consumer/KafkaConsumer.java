package com.prasant.consumer;

import com.prasant.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Author: Prasant
 * Date: 25/10/24
 */

@Slf4j
@Service
public class KafkaConsumer {

	@KafkaListener(topics = "messages", groupId = "myGroup", containerFactory = "stringKafkaListenerContainerFactory")
	public void consumeMsg(String msg){
		log.info("Consuming message from messages Topic :: {}", msg);
	}

	@KafkaListener(topics = "objects", groupId = "myGroup", containerFactory = "jsonKafkaListenerContainerFactory")
	public void consumeJsonMsg(Student student){
		log.info("Consuming student from objects Topic :: {}", student.toString());
	}
}
