package com.gaptextile.infrastructure.web;

import com.gaptextile.application.ChildService;
import com.gaptextile.domain.Child;
import com.gaptextile.domain.exception.ChildNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/children")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class ChildController {

    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @PostMapping
    public ResponseEntity<Child> createChild(@RequestBody ChildRequest request) {
        try {
            Child created = childService.createChild(request.name(), request.currentSize());
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Child>> getAllChildren() {
        return ResponseEntity.ok(childService.getAllChildren());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Child> getChildById(@PathVariable UUID id) {
        return childService.getChildById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Child> updateChild(@PathVariable UUID id, @RequestBody ChildRequest request) {
        return ResponseEntity.ok(childService.updateChild(id, request.name(), request.currentSize()));
    }

    @PatchMapping("/{id}/size")
    public ResponseEntity<Child> updateSize(@PathVariable UUID id, @RequestBody Map<String, String> payload) {
        String newSize = payload.get("size");
        if (newSize == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(childService.updateChildSize(id, newSize));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChild(@PathVariable UUID id) {
        childService.deleteChild(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ChildNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ChildNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    public record ChildRequest(String name, String currentSize) {
    }
}
