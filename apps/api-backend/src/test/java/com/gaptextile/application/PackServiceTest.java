package com.gaptextile.application;

import com.gaptextile.domain.Pack;
import com.gaptextile.domain.ports.output.PackRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PackServiceTest {

    @Mock
    private PackRepositoryPort repository;

    private PackService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new PackService(repository);
    }

    @Test
    void shouldCreatePack() {
        Pack pack = new Pack(null, "Ski", true, false);
        Pack savedPack = new Pack(UUID.randomUUID(), "Ski", true, false);

        when(repository.save(any(Pack.class))).thenReturn(savedPack);

        Pack result = service.createPack("Ski", true);

        assertNotNull(result.id());
        assertEquals("Ski", result.name());
        assertTrue(result.isActive());
        verify(repository).save(any(Pack.class));
    }

    @Test
    void shouldNotDeleteSystemPack() {
        UUID id = UUID.randomUUID();
        Pack systemPack = new Pack(id, "Essentiels", true, true);

        when(repository.findById(id)).thenReturn(Optional.of(systemPack));

        assertThrows(IllegalArgumentException.class, () -> service.deletePack(id));
        verify(repository, never()).deleteById(id);
    }

    @Test
    void shouldDeleteNonSystemPack() {
        UUID id = UUID.randomUUID();
        Pack userPack = new Pack(id, "Ski", true, false);

        when(repository.findById(id)).thenReturn(Optional.of(userPack));

        service.deletePack(id);
        verify(repository).deleteById(id);
    }
}
