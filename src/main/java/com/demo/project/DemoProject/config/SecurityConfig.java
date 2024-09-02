package com.demo.project.DemoProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF (not recommended for production, but useful for development/testing)
        http.csrf(csrf -> csrf.disable());

        // Allow all requests without authentication
        http.authorizeHttpRequests(authz -> authz
                .anyRequest().permitAll()
        );

        return http.build();
    }
}
