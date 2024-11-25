package com.auradecristal.aura_de_cristal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir todos los endpoints
                .allowedOrigins("https://aura-de-cristal.vercel.app") // Permitir solo el origen necesario
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Todos los encabezados
                .exposedHeaders("Authorization", "Content-Type") // Encabezados expuestos si son necesarios
                .allowCredentials(true); // Habilitar credenciales
    }
}