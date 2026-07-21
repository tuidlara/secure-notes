package com.arthur.secure_notes.config;

import com.arthur.secure_notes.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {

        return Jwts.builder()
                //dono principal do token -> email
                .subject(usuario.getEmail())
                .signWith(getKey())
                //finaliza e transforma em uma String
                .compact();
    }

    public String validarToken(String token) {

        return Jwts.parser()
                //verificar assinatura
                .verifyWith(getKey())
                .build()
                //jwt analisado
                .parseSignedClaims(token)
                //conteúdo interno do token
                .getPayload()
                .getSubject();
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

    }
}
