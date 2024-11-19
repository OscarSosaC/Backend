package com.auradecristal.aura_de_cristal.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        auth -> {
                            //cambiar rutas
                            //endpoints que no requieren autenticacion
                            auth.requestMatchers("/api/auth/**").permitAll();
                            auth.requestMatchers("/h2-console/**").permitAll();
//                            // endopoint que requieren roles especificos
                           auth.requestMatchers(HttpMethod.POST).hasAuthority("ADMIN");
//                            auth.requestMatchers(HttpMethod.PUT, "/odontologo/**").hasAuthority("ADMIN");
                            auth.requestMatchers(HttpMethod.DELETE).hasAuthority("ADMIN");
//                            // endpoints que requieren autenticacion (al menos el rol de usuario)
                            auth.requestMatchers("/api/usuario/**").authenticated();
                            auth.requestMatchers(HttpMethod.GET).permitAll();

                            // endpoints de swagger
                            auth.requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll();
                            auth.requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll();
                            auth.requestMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll();

                            auth.anyRequest().authenticated();
                        })
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                .build();

    }
}