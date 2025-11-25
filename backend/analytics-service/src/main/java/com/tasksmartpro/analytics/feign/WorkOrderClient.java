package com.tasksmartpro.analytics.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "workorder-service",
        url = "${WORKORDER_SERVICE_URL:http://localhost:8084/workorders}"
)
public interface WorkOrderClient {

    @GetMapping("/count/open")
    Integer countOpen();

    @GetMapping("/count/overdue")
    Integer countOverdue();

    @GetMapping("/count/completed")
    Integer countCompleted();
}
