package com.gaptextile.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface JpaInventoryRepository extends JpaRepository<InventoryItemEntity, UUID> {
    List<InventoryItemEntity> findByChildId(UUID childId);
}
