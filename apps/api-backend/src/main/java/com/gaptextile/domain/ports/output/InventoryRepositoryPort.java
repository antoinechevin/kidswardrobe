package com.gaptextile.domain.ports.output;

import com.gaptextile.domain.InventoryItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InventoryRepositoryPort {
    InventoryItem save(InventoryItem item);

    List<InventoryItem> findByChildId(UUID childId);

    Optional<InventoryItem> findById(UUID id);
    // Might need delete later
}
