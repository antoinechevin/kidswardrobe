package com.gaptextile.application;

import com.gaptextile.domain.Child;
import com.gaptextile.domain.ClothingSize;
import com.gaptextile.domain.ClothingType;
import com.gaptextile.domain.InventoryItem;
import com.gaptextile.domain.ports.output.ChildRepositoryPort;
import com.gaptextile.domain.ports.output.ClothingTypeRepositoryPort;
import com.gaptextile.domain.ports.output.InventoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InventoryService {

    private final InventoryRepositoryPort inventoryRepository;
    private final ChildRepositoryPort childRepository;
    private final ClothingTypeRepositoryPort clothingTypeRepository;

    public InventoryService(InventoryRepositoryPort inventoryRepository,
            ChildRepositoryPort childRepository,
            ClothingTypeRepositoryPort clothingTypeRepository) {
        this.inventoryRepository = inventoryRepository;
        this.childRepository = childRepository;
        this.clothingTypeRepository = clothingTypeRepository;
    }

    public InventoryItem addItem(UUID childId, UUID clothingTypeId, ClothingSize size, int quantity) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("Child not found: " + childId));

        ClothingType clothingType = clothingTypeRepository.findById(clothingTypeId)
                .orElseThrow(() -> new IllegalArgumentException("ClothingType not found: " + clothingTypeId));

        InventoryItem item = new InventoryItem(child, clothingType, size, quantity);
        return inventoryRepository.save(item);
    }

    public List<InventoryItem> getItemsByChildId(UUID childId) {
        return inventoryRepository.findByChildId(childId);
    }
}
