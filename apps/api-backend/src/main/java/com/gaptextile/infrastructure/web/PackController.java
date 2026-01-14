package com.gaptextile.infrastructure.web;

import com.gaptextile.application.PackService;
import com.gaptextile.domain.Pack;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/packs")
@CrossOrigin(origins = "http://localhost:3000")
public class PackController {

    private final PackService service;

    public PackController(PackService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pack>> getAllPacks() {
        return ResponseEntity.ok(service.getAllPacks());
    }

    @PostMapping
    public ResponseEntity<Pack> createPack(@RequestBody CreatePackRequest request) {
        Pack created = service.createPack(request.name(), request.isActive() != null ? request.isActive() : true);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pack> getPack(@PathVariable UUID id) {
        return service.getPackById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pack> updatePack(@PathVariable UUID id, @RequestBody UpdatePackRequest request) {
        try {
            Pack updated = service.updatePack(id, request.name(), request.isActive());
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePack(@PathVariable UUID id) {
        try {
            service.deletePack(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // Or 403 Forbidden for system pack?
        }
    }

    public record CreatePackRequest(String name, Boolean isActive) {
    }

    public record UpdatePackRequest(String name, boolean isActive) {
    }
}
