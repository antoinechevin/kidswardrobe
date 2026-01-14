package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.Seasonality;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "clothing_types")
public class ClothingTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Seasonality seasonality;

    public ClothingTypeEntity() {
    }

    public ClothingTypeEntity(UUID id, String name, Seasonality seasonality) {
        this.id = id;
        this.name = name;
        this.seasonality = seasonality;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seasonality getSeasonality() {
        return seasonality;
    }

    public void setSeasonality(Seasonality seasonality) {
        this.seasonality = seasonality;
    }
}
