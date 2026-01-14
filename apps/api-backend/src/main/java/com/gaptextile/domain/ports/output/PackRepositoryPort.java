package com.gaptextile.domain.ports.output;

import com.gaptextile.domain.Pack;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PackRepositoryPort {
    Pack save(Pack pack);

    List<Pack> findAll();

    Optional<Pack> findById(UUID id);

    void deleteById(UUID id);
}
