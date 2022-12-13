package com.example.music.music.segurida;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class tokenUtils {

    private final static String TOKEN = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
    private final static Long TOKEN_VALIDACION_SEGUNDOS= 2_592_00L;


    public static String createToken(String nombre, String email){
        long expiracionToken = TOKEN_VALIDACION_SEGUNDOS * 1_000;
        Date experacionFecha = new Date(System.currentTimeMillis() + expiracionToken);
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(experacionFecha)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(TOKEN.getBytes()))
                .compact();
    }

    public  static UsernamePasswordAuthenticationToken autenticacion(String token){
        try {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(TOKEN.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

        String email = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        }catch (JwtException e){
            return null;
        }
    }
}
