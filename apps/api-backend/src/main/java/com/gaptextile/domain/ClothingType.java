package com.gaptextile.domain;

import java.util.UUID;

public class ClothingType {

    private UUID id;
    private String name;
    private Seasonality seasonality;

    public ClothingType() {
    }

    public ClothingType(UUID id, String name, Seasonality seasonality) {
        this.id = id;
        this.name = name;
        this.seasonality = seasonality;
    }

    public ClothingType(String name, Seasonality seasonality) {
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
