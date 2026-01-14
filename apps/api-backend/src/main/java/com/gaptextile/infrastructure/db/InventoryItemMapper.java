package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.InventoryItem;
import org.springframework.stereotype.Component;

@Component
public class InventoryItemMapper {
    private final ChildMapper childMapper; // Assuming ChildMapper exists
    private final ClothingTypeMapper clothingTypeMapper;

    public InventoryItemMapper(ChildMapper childMapper, ClothingTypeMapper clothingTypeMapper) {
        this.childMapper = childMapper;
        this.clothingTypeMapper = clothingTypeMapper;
    }

    public InventoryItem toDomain(InventoryItemEntity entity) {
        return new InventoryItem(
                entity.getId(),
                childMapper.toDomain(entity.getChild()), // Need to verify ChildMapper
                clothingTypeMapper.toDomain(entity.getClothingType()),
                entity.getSize(),
                entity.getQuantity());
    }

    public InventoryItemEntity toEntity(InventoryItem domain) {
        return new InventoryItemEntity(
                domain.getId(),
                childMapper.toEntity(domain.getChild()),
                clothingTypeMapper.toEntity(domain.getClothingType()),
                domain.getSize(),
                domain.getQuantity());
    }
}
