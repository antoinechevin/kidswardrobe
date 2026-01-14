package com.gaptextile.infrastructure.web;

import com.gaptextile.application.ClothingTypeService;
import com.gaptextile.domain.ClothingType;
import com.gaptextile.domain.Seasonality;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clothing-types")
@CrossOrigin(origins = "http://localhost:3000")
public class ClothingTypeController {

    private final ClothingTypeService service;

    public ClothingTypeController(ClothingTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClothingType>> getAllTypes() {
        return ResponseEntity.ok(service.getAllTypes());
    }

    @PostMapping
    public ResponseEntity<ClothingType> createType(@RequestBody ClothingTypeRequest request) {
        ClothingType created = service.createType(
                request.name(),
                Seasonality.valueOf(request.seasonality()));
        return ResponseEntity.ok(created);
    }

    public record ClothingTypeRequest(String name, String seasonality) {
    }
}
