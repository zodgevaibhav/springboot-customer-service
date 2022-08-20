package org.openvz.customer.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumeMessage {
	
	@KafkaListener(topics = "customer-address", groupId = "customer")
	public void listenGroupFoo(String message) {
	    System.out.println("############ Received Message by Customer Service : " + message);
	}

}
