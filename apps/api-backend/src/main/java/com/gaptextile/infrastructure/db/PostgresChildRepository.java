package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.Child;
import com.gaptextile.domain.ports.output.ChildRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PostgresChildRepository implements ChildRepositoryPort {

    private final JpaChildRepository jpaRepository;
    private final ChildMapper mapper;

    public PostgresChildRepository(JpaChildRepository jpaRepository, ChildMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Child save(Child child) {
        ChildEntity entity = mapper.toEntity(child);
        ChildEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Child> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Child> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
