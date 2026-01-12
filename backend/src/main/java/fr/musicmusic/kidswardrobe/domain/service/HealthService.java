package fr.musicmusic.kidswardrobe.domain.service;

import fr.musicmusic.kidswardrobe.domain.model.HealthStatus;
import fr.musicmusic.kidswardrobe.domain.port.in.CheckHealthUseCase;

/**
 * Implementation of the health check use case.
 * No external dependencies, pure business logic.
 */
public class HealthService implements CheckHealthUseCase {

    @Override
    public HealthStatus check() {
        return HealthStatus.up();
    }
}
