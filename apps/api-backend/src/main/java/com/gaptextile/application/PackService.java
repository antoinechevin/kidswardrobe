package com.gaptextile.application;

import com.gaptextile.domain.Pack;
import com.gaptextile.domain.ports.output.PackRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PackService {

    private final PackRepositoryPort repository;

    public PackService(PackRepositoryPort repository) {
        this.repository = repository;
    }

    public Pack createPack(String name, boolean isActive) {
        Pack pack = new Pack(null, name, isActive, false);
        return repository.save(pack);
    }

    public List<Pack> getAllPacks() {
        return repository.findAll();
    }

    public Optional<Pack> getPackById(UUID id) {
        return repository.findById(id);
    }

    public Pack updatePack(UUID id, String name, boolean isActive) {
        // Simple update: fetch, verify existence, update.
        // In a clearer domain model, we might have domain methods.
        // Here we just recreate the record with new values and same ID/system flag.
        return repository.findById(id).map(existing -> {
            Pack updated = new Pack(id, name, isActive, existing.isSystem());
            return repository.save(updated);
        }).orElseThrow(() -> new IllegalArgumentException("Pack not found: " + id));
    }

    public void deletePack(UUID id) {
        Pack pack = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pack not found: " + id));

        if (pack.isSystem()) {
            throw new IllegalArgumentException("Cannot delete system pack");
        }
        repository.deleteById(id);
    }
}
