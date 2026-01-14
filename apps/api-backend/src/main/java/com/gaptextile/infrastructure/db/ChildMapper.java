package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.Child;
import com.gaptextile.domain.ClothingSize;
import org.springframework.stereotype.Component;

@Component
public class ChildMapper {

    public Child toDomain(ChildEntity entity) {
        if (entity == null)
            return null;
        return new Child(entity.getId(), entity.getName(), ClothingSize.fromLabel(entity.getCurrentSize()));
    }

    public ChildEntity toEntity(Child domain) {
        if (domain == null)
            return null;
        return new ChildEntity(domain.getId(), domain.getName(), domain.getCurrentSize().getLabel());
    }
}
