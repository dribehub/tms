package com.tms.security;

import com.tms.enums.RoleEnum;
import com.tms.service.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;

import static com.tms.enums.RoleEnum.*;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static org.springframework.security.config.http.SessionCreationPolicy.*;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsServiceImpl service;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * HTTP configuration & routes
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http    // Enable Cross-Origin Resource Sharing
                .cors().and()

                // Disable Cross-Site Request Forgery
                .csrf().disable()

                // Set session management to stateless
                .sessionManagement().sessionCreationPolicy(STATELESS).and()

                // Set unauthorized requests exception handler
                .exceptionHandling().authenticationEntryPoint((req, res, ex) ->
                        res.sendError(SC_UNAUTHORIZED, ex.getMessage())).and()

                // Set permissions on endpoints
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/users/**").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.GET, "/api/trips/**").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.GET, "/api/trips/update").hasAnyRole(RoleEnum.names())
                .antMatchers(HttpMethod.GET, "/api/trips/sendApprovalById").hasRole(USER.name())
                .antMatchers(HttpMethod.GET, "/api/trips/create").hasRole(USER.name())
                .antMatchers(HttpMethod.GET, "/api/flights/**").hasRole(USER.name())
                .antMatchers(HttpMethod.GET, "/api/countries/**").hasRole(ADMIN.name())
                .anyRequest().authenticated().and()

                // Set logout url
                .logout(logout -> logout.logoutUrl("/auth/logout").invalidateHttpSession(true));

        return http.build();
    }

    /**
     * Used by Spring Security if CORS is enabled.
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin(CorsConfiguration.ALL);
        config.addAllowedHeader(CorsConfiguration.ALL);
        config.addAllowedMethod(CorsConfiguration.ALL);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    /**
     * Explicitly exposes AuthenticationManager as a bean
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
