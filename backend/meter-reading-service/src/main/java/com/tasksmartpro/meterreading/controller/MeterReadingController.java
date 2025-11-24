package com.tasksmartpro.meterreading.controller;

import com.tasksmartpro.meterreading.dto.CreateMeterReadingRequest;
import com.tasksmartpro.meterreading.dto.MeterReadingResponse;
import com.tasksmartpro.meterreading.service.MeterReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meter-readings")
@RequiredArgsConstructor
public class MeterReadingController {

    private final MeterReadingService service;

    @PostMapping
    public ResponseEntity<MeterReadingResponse> create(@RequestBody CreateMeterReadingRequest request) {
        return ResponseEntity.ok(service.createReading(request));
    }

    @GetMapping
    public ResponseEntity<List<MeterReadingResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeterReadingResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/by-asset/{assetId}")
    public ResponseEntity<List<MeterReadingResponse>> getByAsset(@PathVariable Long assetId) {
        return ResponseEntity.ok(service.findByAsset(assetId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
