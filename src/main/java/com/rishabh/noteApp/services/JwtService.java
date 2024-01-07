package com.rishabh.noteApp.services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
    public String extractUsername(String token);
    public String generateToken(UserDetails userDetails);
    public boolean isTokenValid(String token, UserDetails userDetails);
    public String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
}
