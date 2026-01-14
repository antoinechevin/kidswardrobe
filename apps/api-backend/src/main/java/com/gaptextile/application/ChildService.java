package com.gaptextile.application;

import com.gaptextile.domain.Child;
import com.gaptextile.domain.ClothingSize;
import com.gaptextile.domain.exception.ChildNotFoundException;
import com.gaptextile.domain.ports.output.ChildRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChildService {

    private final ChildRepositoryPort childRepository;

    public ChildService(ChildRepositoryPort childRepository) {
        this.childRepository = childRepository;
    }

    public Child createChild(String name, String currentSizeLabel) {
        ClothingSize size = ClothingSize.fromLabel(currentSizeLabel);
        Child child = new Child(name, size);
        return childRepository.save(child);
    }

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    public Optional<Child> getChildById(UUID id) {
        return childRepository.findById(id);
    }

    public Child updateChild(UUID id, String name, String currentSizeLabel) {
        return childRepository.findById(id)
                .map(child -> {
                    if (name != null)
                        child.setName(name);
                    if (currentSizeLabel != null)
                        child.setCurrentSize(ClothingSize.fromLabel(currentSizeLabel));
                    return childRepository.save(child);
                })
                .orElseThrow(() -> new ChildNotFoundException("Child not found with id: " + id));
    }

    public Child updateChildSize(UUID id, String newSizeLabel) {
        return updateChild(id, null, newSizeLabel);
    }

    public void deleteChild(UUID id) {
        if (childRepository.findById(id).isEmpty()) {
            throw new ChildNotFoundException("Child not found with id: " + id);
        }
        childRepository.deleteById(id);
    }
}
