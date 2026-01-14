package com.gaptextile.infrastructure.db;

import com.gaptextile.domain.ClothingSize;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "inventory_items")
public class InventoryItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "child_id")
    private ChildEntity child;

    @ManyToOne(optional = false)
    @JoinColumn(name = "clothing_type_id")
    private ClothingTypeEntity clothingType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClothingSize size;

    @Column(nullable = false)
    private int quantity;

    public InventoryItemEntity() {
    }

    public InventoryItemEntity(UUID id, ChildEntity child, ClothingTypeEntity clothingType, ClothingSize size,
            int quantity) {
        this.id = id;
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

    public ChildEntity getChild() {
        return child;
    }

    public void setChild(ChildEntity child) {
        this.child = child;
    }

    public ClothingTypeEntity getClothingType() {
        return clothingType;
    }

    public void setClothingType(ClothingTypeEntity clothingType) {
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
