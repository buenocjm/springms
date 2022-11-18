package com.taller.notificationsms.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.taller.notificationsms.events.Event;
import com.taller.notificationsms.events.notifievent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class notifiEventService {
	@KafkaListener(
			topics = "${topic.customer.name:customer}",
			containerFactory = "kafkaListenerContainerFactory",
	groupId = "2")
	public void consumer(Event<?> event) {
		if (event.getClass().isAssignableFrom(notifievent.class)) {
			notifievent notifiEvenT = (notifievent) event;
			log.info("Received Customer created event .... with Id={}, data={}",
					notifiEvenT.getId(),
					notifiEvenT.getData().toString());
		}

	}
}
