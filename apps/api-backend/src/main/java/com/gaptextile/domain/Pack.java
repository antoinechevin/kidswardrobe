package com.gaptextile.domain;

import java.util.UUID;

public record Pack(UUID id, String name, boolean isActive, boolean isSystem) {
    public Pack {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Pack name cannot be null or blank");
        }
    }
}
