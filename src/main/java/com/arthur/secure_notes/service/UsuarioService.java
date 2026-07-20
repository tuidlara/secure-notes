package com.arthur.secure_notes.service;

import com.arthur.secure_notes.dto.CadastroRequestDTO;
import com.arthur.secure_notes.entity.Usuario;
import com.arthur.secure_notes.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrar(CadastroRequestDTO dto) {
        String senhaCriptografada = passwordEncoder.encode(dto.getSenha());

        Usuario usuario = new Usuario(
                dto.getEmail(),
                senhaCriptografada
        );

        usuarioRepository.save(usuario);
    }
}
