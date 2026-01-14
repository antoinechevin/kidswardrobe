package com.gaptextile.domain;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class PackTest {

    @Test
    void shouldCreatePack() {
        UUID id = UUID.randomUUID();
        Pack pack = new Pack(id, "Vacances", true, false);

        assertEquals(id, pack.id());
        assertEquals("Vacances", pack.name());
        assertTrue(pack.isActive());
        assertFalse(pack.isSystem());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pack(UUID.randomUUID(), null, true, false);
        });
    }

    @Test
    void shouldThrowExceptionWhenNameIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pack(UUID.randomUUID(), "  ", true, false);
        });
    }
}
