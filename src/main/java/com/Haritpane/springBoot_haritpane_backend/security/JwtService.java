package com.Haritpane.springBoot_haritpane_backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "mySuperSecretKeyForJwtAuthentication123456789";


    // =========================================================
    // FARMER TOKEN
    // =========================================================

    public String generateToken(Long farmerId) {

        Map<String, Object> claims = new HashMap<>();

        claims.put("userType", "FARMER");
        claims.put("role", "ROLE_FARMER");

        return createToken(
                claims,
                String.valueOf(farmerId)
        );
    }


    // =========================================================
    // PROVIDER TOKEN
    // =========================================================

    public String generateToken(Long providerId, String role) {

        Map<String, Object> claims = new HashMap<>();

        claims.put("userType", "PROVIDER");
        claims.put("role", role);

        return createToken(
                claims,
                String.valueOf(providerId)
        );
    }


    // =========================================================
    // CREATE TOKEN
    // =========================================================

    private String createToken(
            Map<String, Object> claims,
            String subject) {

        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60
                        )
                )
                .signWith(
                        getSigningKey(),
                        Jwts.SIG.HS256
                )
                .compact();
    }


    // =========================================================
    // EXTRACT USER ID
    // =========================================================

    public String extractUsername(String token) {

        return extractClaim(
                token,
                Claims::getSubject
        );
    }


    // =========================================================
    // EXTRACT USER TYPE
    // =========================================================

    public String extractUserType(String token) {

        return extractClaim(
                token,
                claims -> claims.get(
                        "userType",
                        String.class
                )
        );
    }


    // =========================================================
    // EXTRACT ROLE
    // =========================================================

    public String extractRole(String token) {

        return extractClaim(
                token,
                claims -> claims.get(
                        "role",
                        String.class
                )
        );
    }


    // =========================================================
    // EXTRACT EXPIRATION
    // =========================================================

    public Date extractExpiration(String token) {

        return extractClaim(
                token,
                Claims::getExpiration
        );
    }


    // =========================================================
    // EXTRACT ANY CLAIM
    // =========================================================

    public <T> T extractClaim(
            String token,
            Function<Claims, T> claimsResolver) {

        Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }


    // =========================================================
    // EXTRACT ALL CLAIMS
    // =========================================================

    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    // =========================================================
    // CHECK EXPIRATION
    // =========================================================

    private boolean isTokenExpired(String token) {

        return extractExpiration(token)
                .before(new Date());
    }


    // =========================================================
    // VALIDATE TOKEN
    // =========================================================

    public boolean isTokenValid(
            String token,
            UserDetails userDetails) {

        final String username =
                extractUsername(token);

        return username.equals(
                userDetails.getUsername()
        )
                && !isTokenExpired(token);
    }


    // =========================================================
    // SECRET KEY
    // =========================================================

    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes(
                        StandardCharsets.UTF_8
                )
        );
    }
}