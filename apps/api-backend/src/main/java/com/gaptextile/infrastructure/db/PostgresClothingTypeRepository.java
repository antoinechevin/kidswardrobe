package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.ClothingType;
import com.gaptextile.domain.ports.output.ClothingTypeRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PostgresClothingTypeRepository implements ClothingTypeRepositoryPort {

    private final JpaClothingTypeRepository jpaRepository;
    private final ClothingTypeMapper mapper;

    public PostgresClothingTypeRepository(JpaClothingTypeRepository jpaRepository, ClothingTypeMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ClothingType save(ClothingType clothingType) {
        ClothingTypeEntity entity = mapper.toEntity(clothingType);
        ClothingTypeEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public List<ClothingType> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClothingType> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
