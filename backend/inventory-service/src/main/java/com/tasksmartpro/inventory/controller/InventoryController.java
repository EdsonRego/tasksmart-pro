package com.tasksmartpro.inventory.controller;

import com.tasksmartpro.inventory.dto.*;
import com.tasksmartpro.inventory.entity.*;
import com.tasksmartpro.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/item")
    public ResponseEntity<Item> createItem(@RequestBody CreateItemRequest req) {
        return ResponseEntity.ok(inventoryService.createItem(req));
    }

    @PostMapping("/supplier")
    public ResponseEntity<Supplier> createSupplier(@RequestBody SupplierRequest req) {
        return ResponseEntity.ok(inventoryService.createSupplier(req));
    }

    @PostMapping("/movement")
    public ResponseEntity<StockMovement> updateStock(@RequestBody UpdateStockRequest req) {
        return ResponseEntity.ok(inventoryService.updateStock(req));
    }
}
