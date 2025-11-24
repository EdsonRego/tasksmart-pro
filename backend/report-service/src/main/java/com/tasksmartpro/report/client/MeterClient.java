package com.tasksmartpro.report.client;

import com.tasksmartpro.report.dto.meter.MeterReadingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "meter-reading-service", url = "http://localhost:8089")
public interface MeterClient {

    @GetMapping("/meter-readings/by-asset/{assetId}")
    List<MeterReadingDto> findByAsset(@PathVariable Long assetId);
}
