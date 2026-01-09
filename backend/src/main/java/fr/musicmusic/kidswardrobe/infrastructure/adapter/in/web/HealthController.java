package fr.musicmusic.kidswardrobe.infrastructure.adapter.in.web;

import fr.musicmusic.kidswardrobe.domain.model.HealthStatus;
import fr.musicmusic.kidswardrobe.domain.port.in.CheckHealthUseCase;
import fr.musicmusic.kidswardrobe.infrastructure.adapter.in.web.dto.HealthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for the health endpoint.
 * Follows hexagonal architecture: Controller → UseCase → Service.
 */
@RestController
@RequestMapping("/api")
public class HealthController {

    private final CheckHealthUseCase checkHealthUseCase;

    public HealthController(CheckHealthUseCase checkHealthUseCase) {
        this.checkHealthUseCase = checkHealthUseCase;
    }

    @GetMapping("/health")
    public ResponseEntity<HealthResponse> health() {
        HealthStatus status = checkHealthUseCase.check();
        return ResponseEntity.ok(HealthResponse.fromDomain(status));
    }
}
