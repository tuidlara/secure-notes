package com.arthur.secure_notes.service;

import com.arthur.secure_notes.dto.CadastroRequestDTO;
import com.arthur.secure_notes.entity.Usuario;
import com.arthur.secure_notes.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrar(CadastroRequestDTO dto) {
        Usuario usuario = new Usuario(
                dto.getEmail(),
                dto.getSenha()
        );

        usuarioRepository.save(usuario);
    }
}
