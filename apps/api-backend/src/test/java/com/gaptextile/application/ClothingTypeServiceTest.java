package com.gaptextile.application;

import com.gaptextile.domain.ClothingType;
import com.gaptextile.domain.Seasonality;
import com.gaptextile.domain.ports.output.ClothingTypeRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClothingTypeServiceTest {

    @Mock
    private ClothingTypeRepositoryPort repository;

    @InjectMocks
    private ClothingTypeService service;

    private ClothingType sampleType;

    @BeforeEach
    void setUp() {
        sampleType = new ClothingType(UUID.randomUUID(), "Bodysuit", Seasonality.ALL_YEAR);
    }

    @Test
    void createType_ShouldSaveAndReturn() {
        when(repository.save(any(ClothingType.class))).thenReturn(sampleType);

        ClothingType created = service.createType("Bodysuit", Seasonality.ALL_YEAR);

        assertNotNull(created);
        assertEquals("Bodysuit", created.getName());
        assertEquals(Seasonality.ALL_YEAR, created.getSeasonality());
        verify(repository).save(any(ClothingType.class));
    }

    @Test
    void getAllTypes_ShouldReturnList() {
        when(repository.findAll()).thenReturn(List.of(sampleType));

        List<ClothingType> types = service.getAllTypes();

        assertFalse(types.isEmpty());
        assertEquals(1, types.size());
    }
}
