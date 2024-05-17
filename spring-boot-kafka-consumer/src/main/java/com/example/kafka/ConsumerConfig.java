package com.example.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class ConsumerConfig {
	
	@Value("${kafka.broker.address}")
	private String kafkaBrokerAddress;
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String,Object> configMap=new HashMap<>();
		configMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokerAddress);
		configMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "consumer-group");
		configMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configMap);
	}

}
