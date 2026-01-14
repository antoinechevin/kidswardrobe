package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.Seasonality;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClothingTypeInitializer implements CommandLineRunner {

    private final JpaClothingTypeRepository repository;

    public ClothingTypeInitializer(JpaClothingTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            initializeDefaults();
        }
    }

    private void initializeDefaults() {
        List<ClothingTypeEntity> defaults = List.of(
                new ClothingTypeEntity(null, "Body Manches Courtes", Seasonality.SUMMER),
                new ClothingTypeEntity(null, "Body Manches Longues", Seasonality.WINTER),
                new ClothingTypeEntity(null, "T-Shirt", Seasonality.SUMMER),
                new ClothingTypeEntity(null, "Pull / Sweat", Seasonality.WINTER),
                new ClothingTypeEntity(null, "Gilet", Seasonality.MID_SEASON),
                new ClothingTypeEntity(null, "Pantalon", Seasonality.ALL_YEAR),
                new ClothingTypeEntity(null, "Short", Seasonality.SUMMER),
                new ClothingTypeEntity(null, "Legging", Seasonality.MID_SEASON),
                new ClothingTypeEntity(null, "Pyjama Velours", Seasonality.WINTER),
                new ClothingTypeEntity(null, "Pyjama Léger", Seasonality.SUMMER),
                new ClothingTypeEntity(null, "Gigoteuse Hiver", Seasonality.WINTER),
                new ClothingTypeEntity(null, "Gigoteuse Été", Seasonality.SUMMER),
                new ClothingTypeEntity(null, "Chaussettes", Seasonality.ALL_YEAR),
                new ClothingTypeEntity(null, "Manteau", Seasonality.WINTER),
                new ClothingTypeEntity(null, "Veste Légère", Seasonality.MID_SEASON));

        repository.saveAll(defaults);
        System.out.println("Initialized " + defaults.size() + " default clothing types.");
    }
}
