package com.tms.security;

import com.tms.service.impl.UserDetailsServiceImpl;
import com.tms.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {

    private final JwtUtils utils;
    private final UserDetailsServiceImpl service;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {

        try {
            String jwt = parseJwt(req);
            if (jwt != null && utils.validateJwtToken(jwt)) {
                String username = utils.getUserNameFromJwtToken(jwt);
                UserDetails details = service.loadUserByUsername(username);
                Collection<? extends GrantedAuthority> authorities = details.getAuthorities();
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                        details, null, authorities);
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                SecurityContextHolder.getContext().setAuthentication(token);
            }
        } catch (Exception e) {
            log.error("Cannot set user authentication: {}", e.getMessage());
        }

        chain.doFilter(req, res);
    }

    private String parseJwt(HttpServletRequest request) {

        final String bearer = "Bearer ";
        final String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(bearer))
            return headerAuth.substring(bearer.length());

        return null;
    }
}