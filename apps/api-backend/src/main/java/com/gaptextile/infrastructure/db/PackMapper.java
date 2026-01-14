package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.Pack;
import org.springframework.stereotype.Component;

@Component
public class PackMapper {

    public Pack toDomain(PackEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Pack(
                entity.getId(),
                entity.getName(),
                entity.isActive(),
                entity.isSystem());
    }

    public PackEntity toEntity(Pack pack) {
        if (pack == null) {
            return null;
        }
        return new PackEntity(
                pack.id(),
                pack.name(),
                pack.isActive(),
                pack.isSystem());
    }
}
