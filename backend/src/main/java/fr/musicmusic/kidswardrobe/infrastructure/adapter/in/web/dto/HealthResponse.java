package fr.musicmusic.kidswardrobe.infrastructure.adapter.in.web.dto;

import fr.musicmusic.kidswardrobe.domain.model.HealthStatus;

/**
 * Response DTO for the health endpoint.
 * Converts the domain HealthStatus model to REST API format.
 */
public record HealthResponse(
    String status,
    String timestamp,
    String application
) {
    /**
     * Creates a response from a domain HealthStatus.
     */
    public static HealthResponse fromDomain(HealthStatus healthStatus) {
        return new HealthResponse(
            healthStatus.status(),
            healthStatus.timestamp().toString(),
            healthStatus.applicationName()
        );
    }
}
