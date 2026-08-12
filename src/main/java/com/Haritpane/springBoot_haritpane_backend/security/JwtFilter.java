//package com.Haritpane.springBoot_haritpane_backend.security;
//
//import com.Haritpane.springBoot_haritpane_backend.services.CustomUserDetailsService;
//import com.Haritpane.springBoot_haritpane_backend.services.FarmerUserDetailsService;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.JwtException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//@Component
//@RequiredArgsConstructor
//public class JwtFilter extends OncePerRequestFilter {
//
//    private final JwtService jwtService;
//    private final CustomUserDetailsService customUserDetailsService;
//    private final FarmerUserDetailsService farmerUserDetailsService;
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String authHeader = request.getHeader("Authorization");
//
//        // No token → let Spring Security decide
//        if (authHeader == null || authHeader.isBlank()) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String jwt = authHeader;
//
//        try {
//
//            String userId = jwtService.extractUsername(jwt);
//
//            System.out.println("User ID: " + userId);
//
//            if (userId != null &&
//                    SecurityContextHolder.getContext().getAuthentication() == null) {
//
//                UserDetails userDetails =
//                        customUserDetailsService.loadUserByUsername(userId);
//
//                boolean valid = jwtService.isTokenValid(jwt, userDetails);
//
//                System.out.println("Token valid: " + valid);
//
//                if (valid) {
//
//                    UsernamePasswordAuthenticationToken authToken =
//                            new UsernamePasswordAuthenticationToken(
//                                    userDetails,
//                                    null,
//                                    userDetails.getAuthorities()
//                            );
//
//                    authToken.setDetails(
//                            new WebAuthenticationDetailsSource()
//                                    .buildDetails(request)
//                    );
//
//                    SecurityContextHolder.getContext()
//                            .setAuthentication(authToken);
//                }
//            }
//
//        } catch (ExpiredJwtException e) {
//
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.setContentType("application/json");
//
//            response.getWriter().write("""
//                    {
//                        "success": false,
//                        "message": "Token has expired",
//                        "status": 401
//                    }
//                    """);
//
//            return;
//
//        } catch (JwtException e) {
//
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.setContentType("application/json");
//
//            response.getWriter().write("""
//                    {
//                        "success": false,
//                        "message": "Invalid JWT token",
//                        "status": 401
//                    }
//                    """);
//
//            return;
//        }
//
//// IMPORTANT: try-catch ke BAHAR
//        filterChain.doFilter(request, response);
//    }
//}


package com.Haritpane.springBoot_haritpane_backend.security;

import com.Haritpane.springBoot_haritpane_backend.services.CustomUserDetailsService;
import com.Haritpane.springBoot_haritpane_backend.services.FarmerUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
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

    private final CustomUserDetailsService
            customUserDetailsService;

    private final FarmerUserDetailsService
            farmerUserDetailsService;


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader =
                request.getHeader("Authorization");


        // =====================================================
        // TOKEN NOT PROVIDED
        // =====================================================

        if (authHeader == null ||
                authHeader.isBlank()) {

            filterChain.doFilter(
                    request,
                    response
            );

            return;
        }


        String jwt = authHeader;


        try {

            // =================================================
            // EXTRACT USER ID
            // =================================================

            String userId =
                    jwtService.extractUsername(jwt);


            // =================================================
            // EXTRACT USER TYPE
            // =================================================

            String userType =
                    jwtService.extractUserType(jwt);


            System.out.println(
                    "User ID: " + userId
            );

            System.out.println(
                    "User Type: " + userType
            );


            if (userId != null &&
                    SecurityContextHolder
                            .getContext()
                            .getAuthentication() == null) {


                // =============================================
                // LOAD USER ACCORDING TO USER TYPE
                // =============================================

                UserDetails userDetails;


                if ("FARMER".equals(userType)) {

                    userDetails =
                            farmerUserDetailsService
                                    .loadUserByUsername(userId);

                } else if ("PROVIDER".equals(userType)) {

                    userDetails =
                            customUserDetailsService
                                    .loadUserByUsername(userId);

                } else {

                    throw new JwtException(
                            "Invalid user type"
                    );
                }


                // =============================================
                // VALIDATE TOKEN
                // =============================================

                boolean valid =
                        jwtService.isTokenValid(
                                jwt,
                                userDetails
                        );


                System.out.println(
                        "Token valid: " + valid
                );


                if (valid) {

                    UsernamePasswordAuthenticationToken
                            authToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );


                    authToken.setDetails(
                            new WebAuthenticationDetailsSource()
                                    .buildDetails(request)
                    );


                    SecurityContextHolder
                            .getContext()
                            .setAuthentication(
                                    authToken
                            );


                    System.out.println(
                            "Authentication set successfully"
                    );
                }
            }


            // =================================================
            // CONTINUE FILTER CHAIN
            // =================================================

            filterChain.doFilter(
                    request,
                    response
            );


        } catch (ExpiredJwtException e) {

            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );

            response.setContentType(
                    "application/json"
            );

            response.getWriter().write("""
                    {
                        "success": false,
                        "message": "Token has expired",
                        "status": 401
                    }
                    """);

            return;


        } catch (JwtException e) {

            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );

            response.setContentType(
                    "application/json"
            );

            response.getWriter().write("""
                    {
                        "success": false,
                        "message": "Invalid JWT token",
                        "status": 401
                    }
                    """);

            return;


        } catch (Exception e) {

            e.printStackTrace();

            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );

            response.setContentType(
                    "application/json"
            );

            response.getWriter().write("""
                    {
                        "success": false,
                        "message": "Authentication failed",
                        "status": 401
                    }
                    """);

            return;
        }
    }
}