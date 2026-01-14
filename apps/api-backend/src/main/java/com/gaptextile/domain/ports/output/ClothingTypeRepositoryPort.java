package com.gaptextile.domain.ports.output;

import com.gaptextile.domain.ClothingType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClothingTypeRepositoryPort {
    ClothingType save(ClothingType clothingType);

    List<ClothingType> findAll();

    Optional<ClothingType> findById(UUID id);

    void deleteById(UUID id);
}
