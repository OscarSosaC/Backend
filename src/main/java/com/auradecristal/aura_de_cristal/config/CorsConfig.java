package com.auradecristal.aura_de_cristal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
                .allowedOriginPatterns(
                        "https://auradecristalapi-development.up.railway.app/", // Railway con HTTPS
                        "http://localhost/:", // Localhost con cualquier puerto (para desarrollo)
                        "https://localhost:*" // HTTPS en localhost, si es necesario
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
