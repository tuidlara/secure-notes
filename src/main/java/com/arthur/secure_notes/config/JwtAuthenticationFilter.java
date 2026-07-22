package com.arthur.secure_notes.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//analisar cada requisição que chega na API e verificar se existe um JWT válido
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    public JwtAuthenticationFilter(TokenService tokenService) {
        this.tokenService = tokenService;

    }

    @Override
    protected void doFilterInternal(
            //representa a requisição que chegou.
            HttpServletRequest request,
            //representa a resposta que vai ser enviada
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        //verifica se existe um bearer token
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            //remover o Bearer
            String token = authHeader.substring(7);
            String email = tokenService.validarToken(token);

            //criar uma autenticação, onde a identidade é esse email
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            email,
                            //null pq login ja aconteceu
                            null,
                            null
                    );

            //registra o usuário como autenticado
            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);

        }

        filterChain.doFilter(request, response);
    }
}
