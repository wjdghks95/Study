package io.security.corespringsecurity2.config;

import io.security.corespringsecurity2.repository.AccessIpRepository;
import io.security.corespringsecurity2.repository.ResourcesRepository;
import io.security.corespringsecurity2.service.SecurityResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SecurityResourceService securityResourceService(ResourcesRepository resourcesRepository, AccessIpRepository accessIpRepository) {
        SecurityResourceService securityResourceService = new SecurityResourceService(resourcesRepository, accessIpRepository);
        return securityResourceService;
    }
}
