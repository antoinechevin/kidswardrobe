package com.gaptextile.application;

import com.gaptextile.domain.Child;
import com.gaptextile.domain.ClothingSize;
import com.gaptextile.domain.ports.output.ChildRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChildServiceTest {

    @Mock
    private ChildRepositoryPort childRepository;

    @InjectMocks
    private ChildService childService;

    private Child sampleChild;

    @BeforeEach
    void setUp() {
        sampleChild = new Child(UUID.randomUUID(), "Alice", ClothingSize.SIZE_6M);
    }

    @Test
    void createChild_ShouldSaveAndReturnChild() {
        when(childRepository.save(any(Child.class))).thenReturn(sampleChild);

        Child created = childService.createChild("Alice", "6M");

        assertNotNull(created);
        assertEquals("Alice", created.getName());
        verify(childRepository).save(any(Child.class));
    }

    @Test
    void getChildById_ShouldReturnChild_WhenFound() {
        when(childRepository.findById(sampleChild.getId())).thenReturn(Optional.of(sampleChild));

        Optional<Child> found = childService.getChildById(sampleChild.getId());

        assertTrue(found.isPresent());
        assertEquals("Alice", found.get().getName());
    }

    @Test
    void updateChildSize_ShouldUpdateAndSave() {
        String newSize = "12M";
        when(childRepository.findById(sampleChild.getId())).thenReturn(Optional.of(sampleChild));
        when(childRepository.save(any(Child.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Child updated = childService.updateChildSize(sampleChild.getId(), newSize);

        assertEquals(newSize, updated.getCurrentSize().getLabel());
        verify(childRepository).save(sampleChild);
    }
}
