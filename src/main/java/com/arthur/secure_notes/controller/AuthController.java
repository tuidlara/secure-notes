package com.arthur.secure_notes.controller;

import com.arthur.secure_notes.dto.CadastroRequestDTO;
import com.arthur.secure_notes.dto.LoginRequestDTO;
import com.arthur.secure_notes.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registrar")
    public String registrar(@Valid @RequestBody CadastroRequestDTO dto) {
        usuarioService.cadastrar(dto);
        return "Usuário cadastrado com sucesso!";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequestDTO dto) {
        return usuarioService.login(dto);
    }
}


