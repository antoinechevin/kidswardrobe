package com.gaptextile.application;

import com.gaptextile.domain.Child;
import com.gaptextile.domain.ClothingSize;
import com.gaptextile.domain.ClothingType;
import com.gaptextile.domain.InventoryItem;
import com.gaptextile.domain.Seasonality;
import com.gaptextile.domain.ports.output.ChildRepositoryPort;
import com.gaptextile.domain.ports.output.ClothingTypeRepositoryPort;
import com.gaptextile.domain.ports.output.InventoryRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventoryServiceTest {

    @Mock
    private InventoryRepositoryPort inventoryRepository;
    @Mock
    private ChildRepositoryPort childRepository;
    @Mock
    private ClothingTypeRepositoryPort clothingTypeRepository;

    @InjectMocks
    private InventoryService service;

    private Child sampleChild;
    private ClothingType sampleType;
    private InventoryItem sampleItem;

    @BeforeEach
    void setUp() {
        sampleChild = new Child(UUID.randomUUID(), "Alice", ClothingSize.SIZE_6M);
        sampleType = new ClothingType(UUID.randomUUID(), "Bodysuit", Seasonality.ALL_YEAR);
        sampleItem = new InventoryItem(UUID.randomUUID(), sampleChild, sampleType, ClothingSize.SIZE_12M, 3);
    }

    @Test
    void addItem_ShouldSaveAndReturnItem() {
        when(childRepository.findById(sampleChild.getId())).thenReturn(Optional.of(sampleChild));
        when(clothingTypeRepository.findById(sampleType.getId())).thenReturn(Optional.of(sampleType));
        when(inventoryRepository.save(any(InventoryItem.class))).thenReturn(sampleItem);

        InventoryItem created = service.addItem(sampleChild.getId(), sampleType.getId(), ClothingSize.SIZE_12M, 3);

        assertNotNull(created);
        assertEquals(3, created.getQuantity());
        assertEquals(ClothingSize.SIZE_12M, created.getSize());
        verify(inventoryRepository).save(any(InventoryItem.class));
    }

    @Test
    void getItemsByChild_ShouldReturnList() {
        when(inventoryRepository.findByChildId(sampleChild.getId())).thenReturn(List.of(sampleItem));

        List<InventoryItem> items = service.getItemsByChildId(sampleChild.getId());

        assertFalse(items.isEmpty());
        assertEquals(1, items.size());
    }
}
