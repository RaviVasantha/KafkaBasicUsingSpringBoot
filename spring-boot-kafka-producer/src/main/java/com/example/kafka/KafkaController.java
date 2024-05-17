package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello/{message}")
public class KafkaController {
	@Autowired
	private KafkaTemplate<String, String> kf;
	
	@GetMapping
	public String publish(@PathVariable("message") String publishMessage) {
		kf.send("hellotopic", publishMessage);
		return "message published:"+publishMessage;
	}
 
}
