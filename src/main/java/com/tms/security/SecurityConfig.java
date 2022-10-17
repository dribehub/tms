package com.tms.security;

import com.tms.enums.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static com.tms.enums.RoleEnum.ADMIN;
import static com.tms.enums.RoleEnum.USER;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService service;
    private final AuthTokenFilter oncePerRequestFilter;
    private final AuthenticationEntryPoint authEntryPoint;

    /**
     * HTTP configuration & routes
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // Enable Cross-Origin Resource Sharing
                .cors(SecurityConfigurerAdapter::and)

                // Disable Cross-Site Request Forgery
                .csrf(AbstractHttpConfigurer::disable)

                // Set session management to stateless
                .sessionManagement(c -> c.sessionCreationPolicy(STATELESS))

                // Set unauthorized requests exception handler
                .exceptionHandling(c -> c.authenticationEntryPoint(authEntryPoint))

                // Set permissions on endpoints
                .authorizeRequests(c -> c
//                        .antMatchers("/**").permitAll()
                        .antMatchers("/auth/*/**").permitAll()
                        .antMatchers("/swagger-ui/**").permitAll()
                        .antMatchers(GET, "/api/countries/*/**").hasAuthority(ADMIN.name())
                        .antMatchers(GET, "/api/users/*/**").hasAuthority(ADMIN.name())
                        .antMatchers(GET, "/api/trips/*/**").hasAuthority(ADMIN.name())
                        .antMatchers(PUT, "/api/trips/update").hasAnyAuthority(RoleEnum.names())
                        .antMatchers(PUT, "/api/trips/send/**").hasAuthority(USER.name())
                        .antMatchers(GET, "/api/trips/create").hasAuthority(USER.name())
                        .antMatchers(GET, "/api/flights/*/**").hasAuthority(USER.name())
                        .anyRequest().authenticated()
                )

                // Set OncePerRequestFilter
                .addFilterAfter(oncePerRequestFilter, UsernamePasswordAuthenticationFilter.class)

                // Set logout url
                .logout(c -> c.logoutUrl("/auth/logout").invalidateHttpSession(true));

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
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
