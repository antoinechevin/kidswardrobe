package com.gaptextile.domain;

import java.util.UUID;

public class Child {

    private UUID id;
    private String name;
    private ClothingSize currentSize;

    public Child() {
    }

    public Child(UUID id, String name, ClothingSize currentSize) {
        this.id = id;
        this.name = name;
        this.currentSize = currentSize;
    }

    public Child(String name, ClothingSize currentSize) {
        this.name = name;
        this.currentSize = currentSize;
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

    public ClothingSize getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(ClothingSize currentSize) {
        this.currentSize = currentSize;
    }
}
