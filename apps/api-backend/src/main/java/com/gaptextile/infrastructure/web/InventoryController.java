package com.gaptextile.infrastructure.web;

import com.gaptextile.application.InventoryService;
import com.gaptextile.domain.ClothingSize;
import com.gaptextile.domain.InventoryItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InventoryItem> addItem(@RequestBody AddItemRequest request) {
        InventoryItem created = service.addItem(
                request.childId(),
                request.clothingTypeId(),
                ClothingSize.fromLabel(request.size()), // Use fromLabel instead of valueOf
                request.quantity());
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getItems(@RequestParam UUID childId) {
        return ResponseEntity.ok(service.getItemsByChildId(childId));
    }

    public record AddItemRequest(UUID childId, UUID clothingTypeId, String size, int quantity) {
    }
}
