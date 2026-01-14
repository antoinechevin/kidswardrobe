package com.gaptextile.domain.ports.output;

import com.gaptextile.domain.Child;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChildRepositoryPort {
    Child save(Child child);

    Optional<Child> findById(UUID id);

    List<Child> findAll();

    void deleteById(UUID id);
}
