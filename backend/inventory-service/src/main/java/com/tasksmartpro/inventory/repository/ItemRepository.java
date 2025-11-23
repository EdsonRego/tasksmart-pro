package com.tasksmartpro.inventory.repository;

import com.tasksmartpro.inventory.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByTenantId(Long tenantId);
}
