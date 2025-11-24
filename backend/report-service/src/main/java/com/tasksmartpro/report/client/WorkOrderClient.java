package com.tasksmartpro.report.client;

import com.tasksmartpro.report.dto.workorder.WorkOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "workorder-service", url = "http://localhost:8084")
public interface WorkOrderClient {

    @GetMapping("/workorders")
    List<WorkOrderDto> findAll();

    @GetMapping("/workorders/{id}")
    WorkOrderDto findById(@PathVariable Long id);
}
