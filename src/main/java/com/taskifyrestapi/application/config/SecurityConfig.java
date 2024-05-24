package com.taskifyrestapi.application.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .exceptionHandling(exceptionHandlingConfigurer -> 
                    exceptionHandlingConfigurer.authenticationEntryPoint(userAuthenticationEntryPoint)
                )
                .addFilterBefore(new JwtAuthFilter(userAuthenticationProvider), BasicAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sessionManagement -> 
                    sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.GET, "/teamleader/projects/**").hasAuthority("TEAMLEADER")
                        .requestMatchers(HttpMethod.POST, "/teamleader/projects/**").hasAuthority("TEAMLEADER")
                        .requestMatchers(HttpMethod.PUT, "/teamleader/projects/**").hasAuthority("TEAMLEADER")
                        .requestMatchers(HttpMethod.DELETE, "/teamleader/projects/**").hasAuthority("TEAMLEADER")
                        .requestMatchers(HttpMethod.GET, "/teamleader/tasks/**").hasAuthority("TEAMLEADER")
                        .requestMatchers(HttpMethod.POST, "/teamleader/tasks/**").hasAuthority("TEAMLEADER")
                        .requestMatchers(HttpMethod.POST, "/teamleader/tasks/project/**").hasAuthority("TEAMLEADER")
                        .requestMatchers(HttpMethod.PUT, "/teamleader/tasks/**").hasAuthority("TEAMLEADER")
                        .requestMatchers(HttpMethod.DELETE, "/teamleader/tasks/**").hasAuthority("TEAMLEADER")
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .anyRequest().authenticated())
        ;
        return http.build();
    }
}
