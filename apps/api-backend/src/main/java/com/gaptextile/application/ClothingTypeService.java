package com.gaptextile.application;

import com.gaptextile.domain.ClothingType;
import com.gaptextile.domain.Seasonality;
import com.gaptextile.domain.ports.output.ClothingTypeRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClothingTypeService {

    private final ClothingTypeRepositoryPort repository;

    public ClothingTypeService(ClothingTypeRepositoryPort repository) {
        this.repository = repository;
    }

    public ClothingType createType(String name, Seasonality seasonality) {
        ClothingType type = new ClothingType(name, seasonality);
        return repository.save(type);
    }

    public List<ClothingType> getAllTypes() {
        return repository.findAll();
    }
}
