package com.taller.cliente.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.taller.cliente.events.Event;
import com.taller.cliente.events.EventType;
import com.taller.cliente.events.clientevent;
import com.taller.cliente.model.cliente;

@Component
public class ClienteEventsService {
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.customer.name:customer}")
	private String topicCustomer;
	
	public void publish(cliente client) {

		clientevent created = new clientevent();
		
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());
		created.setData(client);

		this.producer.send(topicCustomer, created);
	}
}
