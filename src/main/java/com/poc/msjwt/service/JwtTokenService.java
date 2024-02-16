package com.poc.msjwt.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@SuppressWarnings("deprecation")
@Service
public class JwtTokenService {

    // Genera una clave secreta más segura y adecuada para la versión actualizada.
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Utiliza HS512 para la firma
    private static final long EXPIRATION_TIME = 7200000; // 2 horas

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }
}