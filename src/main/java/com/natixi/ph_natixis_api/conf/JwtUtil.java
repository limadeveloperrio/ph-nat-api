package com.natixi.ph_natixis_api.conf;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;

public class JwtUtil {

    private static final String SECRET = "5eebb082-4046-4d7f-a638-3c16d9dec4f8";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hora

    public static String generateToken(String username, List<String> authorities) {
        return Jwts.builder()
                .setSubject(username)
                .claim("authorities", authorities) // 🔹 adiciona as roles
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET.getBytes())
                .compact();
    }

}
