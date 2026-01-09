package fr.musicmusic.kidswardrobe.infrastructure.config;

import fr.musicmusic.kidswardrobe.domain.port.in.CheckHealthUseCase;
import fr.musicmusic.kidswardrobe.domain.service.HealthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration for domain bean injection.
 * This is where we instantiate domain services (which don't know about Spring).
 */
@Configuration
public class BeanConfig {

    @Bean
    public CheckHealthUseCase checkHealthUseCase() {
        return new HealthService();
    }
}
