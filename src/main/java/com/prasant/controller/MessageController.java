package com.prasant.controller;

import com.prasant.payload.Student;
import com.prasant.producer.KafkaJsonProducer;
import com.prasant.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Prasant
 * Date: 25/10/24
 */

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

	private final KafkaProducer kafkaProducer;

	private final KafkaJsonProducer kafkaJsonProducer;

	@PostMapping
	public ResponseEntity<String> sendMessage(@RequestBody String msg){
		kafkaProducer.sendMessage(msg);

		return ResponseEntity.ok("Message queued successfully!");
	}

	@PostMapping("/json")
	public ResponseEntity<String> sendJsonMessage(@RequestBody Student student){
		kafkaJsonProducer.sendMessage(student);

		return ResponseEntity.ok("Student data queued successfully!");
	}
}
