package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.ClothingType;
import org.springframework.stereotype.Component;

@Component
public class ClothingTypeMapper {

    public ClothingType toDomain(ClothingTypeEntity entity) {
        return new ClothingType(
                entity.getId(),
                entity.getName(),
                entity.getSeasonality());
    }

    public ClothingTypeEntity toEntity(ClothingType domain) {
        return new ClothingTypeEntity(
                domain.getId(),
                domain.getName(),
                domain.getSeasonality());
    }
}
