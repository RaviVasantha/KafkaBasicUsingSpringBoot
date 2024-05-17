package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	@KafkaListener(topics = "hellotopic",groupId = "Consumer-group")
	public void consume(String message) {
		System.out.println("message consumed :"+message);
	}

}
