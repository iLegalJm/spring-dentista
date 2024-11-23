package com.sistemacitas.sistemacitas.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        @Lazy
        private UserDetailsService userDetailsService;

        @Autowired
        @Lazy
        private JwtRequestFilter jwtRequestFilter;

        private static final List<String> PUBLIC_ROUTES = List.of(
                        "/usuario/v1/api/login",
                        "/doctor/v1/api",
                        "/doctor/v1/api/{id}",
                        "/doctor/v1/api",
                        "/especialidad/v1/api",
                        "/especialidad/v1/api/{id}",
                        "/paciente/v1/api",
                        "/paciente/v1/api/{id}");

        private static final List<String> PROTECTED_ROUTES = List.of(
                        "/usuario/v1/api");

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http.csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers(PUBLIC_ROUTES.toArray(new String[0])).permitAll()
                                                .requestMatchers(PROTECTED_ROUTES.toArray(new String[0]))
                                                .authenticated()
                                                .anyRequest().permitAll())
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
                return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
                AuthenticationManagerBuilder authenticationManagerBuilder = http
                                .getSharedObject(AuthenticationManagerBuilder.class);
                authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
                return authenticationManagerBuilder.build();
        }
}
