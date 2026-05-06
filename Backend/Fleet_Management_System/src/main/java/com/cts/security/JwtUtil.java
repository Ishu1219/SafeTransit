package com.cts.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

	   @Value("${jwt.secret}")
	    private String secret;

	    @Value("${jwt.expiry}")
	    private long expiryMs;

	    private Key getKey() {
	        return Keys.hmacShaKeyFor(secret.getBytes());
	    }
	    public String generateToken(Long userId, String email, String role) {
	        return Jwts.builder()
	                .setSubject(email)
	                .claim("userId", userId)
	                .claim("role",   role)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + expiryMs))
	                .signWith(getKey(), SignatureAlgorithm.HS256)
	                .compact();
	    }
	    public String extractEmail(String token) {
	        return parseClaims(token).getSubject();
	    }
	    public String extractRole(String token) {
	        return parseClaims(token).get("role", String.class);
	    }

	    public Long extractUserId(String token) {
	        return parseClaims(token).get("userId", Long.class);
	    }

	    public boolean isTokenValid(String token) {
	        try {
	            parseClaims(token);
	            return true;
	        } catch (JwtException | IllegalArgumentException e) {
	            return false;
	        }
	    }

	    public long getExpirySeconds() {
	        return expiryMs / 1000;
	    }

	    private Claims parseClaims(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(getKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }


}
