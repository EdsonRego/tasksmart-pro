package com.tasksmartpro.integration.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IntegrationResponse {
    private Long jobId;
    private String status;
}
