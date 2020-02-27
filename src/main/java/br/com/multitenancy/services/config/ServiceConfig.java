package br.com.multitenancy.services.config;

import br.com.multitenancy.persistence.PersistenceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfig.class})
public class ServiceConfig {
}
