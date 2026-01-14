package com.gaptextile.infrastructure.db;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "children")
public class ChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String currentSize;

    public ChildEntity() {
    }

    public ChildEntity(UUID id, String name, String currentSize) {
        this.id = id;
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

    public String getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(String currentSize) {
        this.currentSize = currentSize;
    }
}
