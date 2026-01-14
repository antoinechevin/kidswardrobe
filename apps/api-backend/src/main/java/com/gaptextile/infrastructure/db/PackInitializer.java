package com.gaptextile.infrastructure.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PackInitializer implements CommandLineRunner {

    private final JpaPackRepository repository;

    public PackInitializer(JpaPackRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!repository.existsByName("Essentiels")) {
            createDefaultPack();
        }
    }

    private void createDefaultPack() {
        PackEntity essentials = new PackEntity(
                null,
                "Essentiels",
                true,
                true // isSystem = true
        );
        repository.save(essentials);
        System.out.println("Initialized default pack: Essentiels");
    }
}
