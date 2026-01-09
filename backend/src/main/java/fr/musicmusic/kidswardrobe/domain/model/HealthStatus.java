package fr.musicmusic.kidswardrobe.domain.model;

import java.time.Instant;

/**
 * Value Object representing the application health status.
 * Immutable, pure Java - no external dependencies.
 */
public record HealthStatus(
    String status,
    Instant timestamp,
    String applicationName
) {
    /**
     * Factory method to create an UP status.
     */
    public static HealthStatus up() {
        return new HealthStatus("UP", Instant.now(), "KidsWardrobe");
    }

    /**
     * Checks if the application is running.
     */
    public boolean isHealthy() {
        return "UP".equals(status);
    }
}
