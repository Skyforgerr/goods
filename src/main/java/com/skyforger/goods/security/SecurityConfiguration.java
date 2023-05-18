package com.skyforger.goods.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.skyforger.goods.model.Permission.ADMIN_CREATE;
import static com.skyforger.goods.model.Permission.ADMIN_DELETE;
import static com.skyforger.goods.model.Permission.ADMIN_READ;
import static com.skyforger.goods.model.Permission.ADMIN_UPDATE;
import static com.skyforger.goods.model.Permission.MANAGER_CREATE;
import static com.skyforger.goods.model.Permission.MANAGER_DELETE;
import static com.skyforger.goods.model.Permission.MANAGER_READ;
import static com.skyforger.goods.model.Permission.MANAGER_UPDATE;
import static com.skyforger.goods.model.Role.ADMIN;
import static com.skyforger.goods.model.Role.MANAGER;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final CsrfFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**")// Указанное здесь будет доступно для всех пользователей
                .permitAll()

                .requestMatchers("/api/v1/managment/**").hasAnyAuthority(ADMIN.name(), MANAGER.name())

                .requestMatchers(GET, "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
                .requestMatchers(POST, "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
                .requestMatchers(PUT, "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
                .requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())

                .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())

                .requestMatchers(GET, "/api/v1/admin/**").hasAuthority(ADMIN_READ.name())
                .requestMatchers(POST, "/api/v1/admin/**").hasAuthority(ADMIN_CREATE.name())
                .requestMatchers(PUT, "/api/v1/admin/**").hasAuthority(ADMIN_UPDATE.name())
                .requestMatchers(DELETE, "/api/v1/admin/**").hasAuthority(ADMIN_DELETE.name())

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
