package com.tasksmartpro.report.client;

import com.tasksmartpro.report.dto.inventory.StockItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "inventory-service", url = "http://localhost:8087")
public interface InventoryClient {

    @GetMapping("/inventory/items")
    List<StockItemDto> listItems();
}
