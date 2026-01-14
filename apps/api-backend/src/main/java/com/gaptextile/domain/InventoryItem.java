package com.gaptextile.domain;

import java.util.UUID;

public class InventoryItem {
    private UUID id;
    private Child child;
    private ClothingType clothingType;
    private ClothingSize size;
    private int quantity;

    public InventoryItem() {
    }

    public InventoryItem(UUID id, Child child, ClothingType clothingType, ClothingSize size, int quantity) {
        this.id = id;
        this.child = child;
        this.clothingType = clothingType;
        this.size = size;
        this.quantity = quantity;
    }

    public InventoryItem(Child child, ClothingType clothingType, ClothingSize size, int quantity) {
        this.child = child;
        this.clothingType = clothingType;
        this.size = size;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public ClothingType getClothingType() {
        return clothingType;
    }

    public void setClothingType(ClothingType clothingType) {
        this.clothingType = clothingType;
    }

    public ClothingSize getSize() {
        return size;
    }

    public void setSize(ClothingSize size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
