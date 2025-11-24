package com.tasksmartpro.integration.webhook;

import com.tasksmartpro.integration.entity.IntegrationEventLog;
import com.tasksmartpro.integration.repository.IntegrationEventLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/webhooks")
@RequiredArgsConstructor
public class WebhookController {

    private final IntegrationEventLogRepository eventRepo;

    @PostMapping("/receive")
    public ResponseEntity<String> receiveWebhook(@RequestBody String payload) {
        eventRepo.save(
                IntegrationEventLog.builder()
                        .eventType("WEBHOOK_RECEIVED")
                        .data(payload)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return ResponseEntity.ok("Webhook OK");
    }
}
