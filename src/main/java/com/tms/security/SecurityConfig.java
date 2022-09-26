package com.tms.security;

import com.tms.service.UserService;
import com.tms.service.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService::getDetailsByUsername);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http = http.cors().and()   // Enable Cross-Origin Resource Sharing
                .csrf().disable(); // Disable Cross-Site Request Forgery

        // Set session management to stateless
        http = http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http.exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> response.sendError(
                                HttpServletResponse.SC_UNAUTHORIZED,
                                ex.getMessage()))
                .and();

        // Set permissions on endpoints
        http.authorizeRequests()
                // public
                .antMatchers("/auth/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/author/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/author/search").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/book/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/book/search").permitAll()
                // private
//                .antMatchers("/api/admin/user/**").hasRole(Role.USER_ADMIN)
//                .antMatchers("/api/author/**").hasRole(Role.AUTHOR_ADMIN)
//                .antMatchers("/api/book/**").hasRole(Role.BOOK_ADMIN)
                .anyRequest().authenticated();
    }

    // Used by Spring Security if CORS is enabled.
    @Bean
    public CorsFilter corsFilter() {

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

    @Bean @Override // explicitly exposes AuthenticationManager as a bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}