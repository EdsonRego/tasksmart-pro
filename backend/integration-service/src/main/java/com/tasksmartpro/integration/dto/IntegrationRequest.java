package com.tasksmartpro.integration.dto;

import lombok.Data;

@Data
public class IntegrationRequest {
    private String externalSystem;
    private String endpoint;
    private String payload;
}
