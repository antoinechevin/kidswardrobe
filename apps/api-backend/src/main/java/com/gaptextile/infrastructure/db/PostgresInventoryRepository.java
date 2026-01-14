package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.InventoryItem;
import com.gaptextile.domain.ports.output.InventoryRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PostgresInventoryRepository implements InventoryRepositoryPort {

    private final JpaInventoryRepository jpaRepository;
    private final InventoryItemMapper mapper;

    public PostgresInventoryRepository(JpaInventoryRepository jpaRepository, InventoryItemMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public InventoryItem save(InventoryItem item) {
        InventoryItemEntity entity = mapper.toEntity(item);
        InventoryItemEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public List<InventoryItem> findByChildId(UUID childId) {
        return jpaRepository.findByChildId(childId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InventoryItem> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }
}
