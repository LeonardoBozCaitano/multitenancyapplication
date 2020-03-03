package br.com.control;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ControlApplication  extends SpringBootServletInitializer {
    public static void main(String[] args) {
        new ControlApplication()
                .configure(new SpringApplicationBuilder(ControlConfiguration.class))
                .run(args);
    }
}

