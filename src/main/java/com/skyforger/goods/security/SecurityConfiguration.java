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
import com.skyforger.goods.model.Role;
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
                .requestMatchers("/users/view", "/goods/view").hasRole(Role.MANAGER.name())

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
