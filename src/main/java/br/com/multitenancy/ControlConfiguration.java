package br.com.multitenancy;

import br.com.multitenancy.handlers.config.HandlerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({HandlerConfig.class})
@ComponentScan
public class ControlConfiguration {

}
