package com.gaptextile.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaPackRepository extends JpaRepository<PackEntity, UUID> {
    boolean existsByName(String name);
}
