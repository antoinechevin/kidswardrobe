package com.gaptextile.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JpaClothingTypeRepository extends JpaRepository<ClothingTypeEntity, UUID> {
}
