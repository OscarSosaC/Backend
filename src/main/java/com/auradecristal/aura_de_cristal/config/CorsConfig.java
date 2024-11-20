package com.auradecristal.aura_de_cristal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOriginPatterns(
                        "https://auradecristalapi-development.up.railway.app*", // Railway
                        "http://localhost:*", // Localhost con cualquier puerto
                        "https://localhost:*" // HTTPS en localhost (si lo usas)
                )
                .allowedMethods("GET", "POST", "PUT","DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
