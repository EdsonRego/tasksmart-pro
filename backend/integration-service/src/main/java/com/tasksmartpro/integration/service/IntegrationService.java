package com.tasksmartpro.integration.service;

import com.tasksmartpro.integration.dto.IntegrationRequest;
import com.tasksmartpro.integration.dto.IntegrationResponse;
import com.tasksmartpro.integration.entity.IntegrationEventLog;
import com.tasksmartpro.integration.entity.IntegrationJob;
import com.tasksmartpro.integration.feign.ExternalIntegrationClient;
import com.tasksmartpro.integration.repository.IntegrationEventLogRepository;
import com.tasksmartpro.integration.repository.IntegrationJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class IntegrationService {

    private final IntegrationJobRepository jobRepository;
    private final IntegrationEventLogRepository eventLogRepository;
    private final ExternalIntegrationClient externalClient; // novo

    public IntegrationResponse executeIntegration(IntegrationRequest request) {

        IntegrationJob job = IntegrationJob.builder()
                .externalSystem(request.getExternalSystem())
                .endpoint(request.getEndpoint())
                .payload(request.getPayload())
                .status("PENDING")
                .createdAt(LocalDateTime.now())
                .build();

        jobRepository.save(job);

        // Aqui entraria o WebClient/Feign/Kafka futuramente
        job.setExecutedAt(LocalDateTime.now());
        job.setStatus("SUCCESS");
        jobRepository.save(job);

        eventLogRepository.save(
                IntegrationEventLog.builder()
                        .eventType("SYNC_SENT")
                        .data(request.getPayload())
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return IntegrationResponse.builder()
                .jobId(job.getId())
                .status(job.getStatus())
                .build();
    }
}
