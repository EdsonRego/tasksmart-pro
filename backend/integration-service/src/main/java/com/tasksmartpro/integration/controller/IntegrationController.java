package com.tasksmartpro.integration.controller;

import com.tasksmartpro.integration.dto.IntegrationRequest;
import com.tasksmartpro.integration.dto.IntegrationResponse;
import com.tasksmartpro.integration.service.IntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/integrations")
@RequiredArgsConstructor
public class IntegrationController {

    private final IntegrationService integrationService;

    @PostMapping
    public ResponseEntity<IntegrationResponse> createIntegration(@RequestBody IntegrationRequest request) {
        return ResponseEntity.ok(integrationService.executeIntegration(request));
    }
}
