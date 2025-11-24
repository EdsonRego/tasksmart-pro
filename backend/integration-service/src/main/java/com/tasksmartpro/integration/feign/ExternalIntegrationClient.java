package com.tasksmartpro.integration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Cliente genérico para integrar com sistemas externos.
 * A URL real vem de variável de ambiente/propriedade:
 * INTEGRATION_EXTERNAL_BASE_URL
 */
@FeignClient(
        name = "external-integration-client",
        url = "${INTEGRATION_EXTERNAL_BASE_URL:http://localhost:9001}"
)
public interface ExternalIntegrationClient {

    @PostMapping("/integrations")
    String sendPayload(@RequestBody String payload);
}
