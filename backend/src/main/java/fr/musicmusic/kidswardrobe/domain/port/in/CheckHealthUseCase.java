package fr.musicmusic.kidswardrobe.domain.port.in;

import fr.musicmusic.kidswardrobe.domain.model.HealthStatus;

/**
 * Input port: use case for checking application health status.
 * Pure interface, no external dependencies.
 */
public interface CheckHealthUseCase {
    /**
     * Checks the current health status of the application.
     * @return HealthStatus containing the current status
     */
    HealthStatus check();
}
