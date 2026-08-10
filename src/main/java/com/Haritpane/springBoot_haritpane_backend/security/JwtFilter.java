package com.Haritpane.springBoot_haritpane_backend.security;

import com.Haritpane.springBoot_haritpane_backend.services.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        System.out.println("Authorization Header: " + authHeader);
        final String jwt;
        final String providerId;

        // Header missing or invalid
        if (authHeader == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Remove "Bearer " from the header
        jwt = authHeader;

        // Extract email from JWT
        providerId = jwtService.extractUsername(jwt);
        System.out.println("providerId from jwt: " + providerId);

        // Authenticate only if not already authenticated
        UserDetails userDetails = null;
        if (providerId != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            userDetails = customUserDetailsService.loadUserByUsername(providerId);

            if (jwtService.isTokenValid(jwt, userDetails)) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        System.out.println("Token Valid: " + jwtService.isTokenValid(jwt, userDetails));

        filterChain.doFilter(request, response);
    }
}