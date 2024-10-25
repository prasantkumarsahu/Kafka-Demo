package com.prasant.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Author: Prasant
 * Date: 25/10/24
 */

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic myTopic() {
		return TopicBuilder
				.name("prasant")
				.build();
	}
}
