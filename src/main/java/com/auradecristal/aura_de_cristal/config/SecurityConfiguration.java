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

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {

                    auth.requestMatchers("/auth/**").permitAll();
                    auth.requestMatchers(HttpMethod.OPTIONS).permitAll(); // *aca vamos a poner primero la parte de options*
                    auth.requestMatchers(HttpMethod.GET).permitAll();
                    auth.requestMatchers("/usuarios/**").authenticated();
                    auth.requestMatchers(HttpMethod.POST, "/**").hasAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT, "/**").hasAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE, "/**").hasAuthority("ADMIN");
                    auth.anyRequest().authenticated(); // Resto requiere autenticación
                })
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}