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

	@KafkaListener(topics = "prasant", groupId = "myGroup")
	public void consumeMsg(String msg){
		log.info("Consuming message from prasant Topic :: {}", msg);
	}

	@KafkaListener(topics = "prasant", groupId = "myGroup")
	public void consumeJsonMsg(Student student){
		log.info("Consuming student from prasant Topic :: {}", student.toString());
	}
}
