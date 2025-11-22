package com.tasksmartpro.notification.service;

import com.tasksmartpro.notification.dto.EventNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventNotificationService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendEvent(EventNotificationRequest request) {
        kafkaTemplate.send("tasksmartpro-events", request.getPayload());
    }
}
