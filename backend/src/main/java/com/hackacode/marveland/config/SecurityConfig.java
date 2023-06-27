package com.hackacode.marveland.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import com.hackacode.marveland.config.jwt.JwtAuthFilter;
import com.hackacode.marveland.util.enums.Role;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter JwtAuthenticationFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors((cors) -> cors.disable())
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .requestMatchers("/**").permitAll()
                //.requestMatchers("/api/v1/auth/login").permitAll()
                //.requestMatchers("/api/v1/auth/register").hasRole(Role.ADMIN.name())
                //.requestMatchers("/api/v1/customers/**").hasRole(Role.ADMIN.name())
                //.requestMatchers("/api/v1/employees/**").hasRole(Role.ADMIN.name())
                //.requestMatchers("/api/v1/games/**").hasRole(Role.ADMIN.name())
                //.requestMatchers("/api/v1/schedules/**").hasRole(Role.ADMIN.name())
                //.requestMatchers(HttpMethod.GET, "/api/v1/purchases/**")
                //.hasAnyRole(Role.ADMIN.name(), Role.EMPLOYEE.name())
                //.requestMatchers(HttpMethod.POST, "/api/v1/purchases/**").hasRole(Role.EMPLOYEE.name())
                //.requestMatchers(HttpMethod.PATCH, "/api/v1/purchases/**").hasRole(Role.EMPLOYEE.name())
                //.requestMatchers(HttpMethod.DELETE, "/api/v1/purchases/**").hasRole(Role.EMPLOYEE.name())
                //.requestMatchers("/api/v1/tickets/**").hasAnyRole(Role.ADMIN.name(), Role.EMPLOYEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
