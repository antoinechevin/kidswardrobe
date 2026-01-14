package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.Pack;
import com.gaptextile.domain.ports.output.PackRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PostgresPackRepository implements PackRepositoryPort {

    private final JpaPackRepository jpaRepository;
    private final PackMapper mapper;

    public PostgresPackRepository(JpaPackRepository jpaRepository, PackMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Pack save(Pack pack) {
        PackEntity entity = mapper.toEntity(pack);
        PackEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public List<Pack> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pack> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
