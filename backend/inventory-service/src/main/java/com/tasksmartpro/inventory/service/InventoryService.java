package com.tasksmartpro.inventory.service;

import com.tasksmartpro.inventory.dto.*;
import com.tasksmartpro.inventory.entity.*;
import com.tasksmartpro.inventory.enums.MovementType;
import com.tasksmartpro.inventory.exception.NotFoundException;
import com.tasksmartpro.inventory.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final ItemRepository itemRepo;
    private final SupplierRepository supplierRepo;
    private final StockMovementRepository movementRepo;

    public Item createItem(CreateItemRequest req) {
        Supplier supplier = null;

        if (req.getSupplierId() != null) {
            supplier = supplierRepo.findById(req.getSupplierId())
                    .orElseThrow(() -> new NotFoundException("Supplier not found"));
        }

        Item item = Item.builder()
                .tenantId(req.getTenantId())
                .name(req.getName())
                .description(req.getDescription())
                .minimumStock(req.getMinimumStock())
                .stockQuantity(0)
                .supplier(supplier)
                .build();

        return itemRepo.save(item);
    }

    public Supplier createSupplier(SupplierRequest req) {
        Supplier supplier = Supplier.builder()
                .tenantId(req.getTenantId())
                .name(req.getName())
                .email(req.getEmail())
                .phone(req.getPhone())
                .build();

        return supplierRepo.save(supplier);
    }

    public StockMovement updateStock(UpdateStockRequest req) {
        Item item = itemRepo.findById(req.getItemId())
                .orElseThrow(() -> new NotFoundException("Item not found"));

        MovementType type = MovementType.valueOf(req.getMovementType());

        if (type == MovementType.OUT && item.getStockQuantity() < req.getQuantity()) {
            throw new RuntimeException("Not enough stock");
        }

        int newQuantity = type == MovementType.IN
                ? item.getStockQuantity() + req.getQuantity()
                : item.getStockQuantity() - req.getQuantity();

        item.setStockQuantity(newQuantity);
        itemRepo.save(item);

        StockMovement movement = StockMovement.builder()
                .item(item)
                .tenantId(req.getTenantId())
                .movementType(type)
                .movementDate(LocalDateTime.now())
                .quantity(req.getQuantity())
                .workOrderId(req.getWorkOrderId())
                .build();

        return movementRepo.save(movement);
    }
}
