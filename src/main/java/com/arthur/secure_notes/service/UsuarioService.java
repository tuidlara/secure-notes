package com.arthur.secure_notes.service;

import com.arthur.secure_notes.config.TokenService;
import com.arthur.secure_notes.dto.CadastroRequestDTO;
import com.arthur.secure_notes.dto.LoginRequestDTO;
import com.arthur.secure_notes.entity.Usuario;
import com.arthur.secure_notes.exception.CredenciaisInvalidasException;
import com.arthur.secure_notes.exception.EmailJaCadastradoException;
import com.arthur.secure_notes.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;

    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository, TokenService tokenService
    ) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
    }

    public void cadastrar(CadastroRequestDTO dto) {

        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new EmailJaCadastradoException("Email já cadastrado.");
        }

        String senhaCriptografada = passwordEncoder.encode(dto.getSenha());

        Usuario usuario = new Usuario(
                dto.getEmail(),
                senhaCriptografada
        );

        usuarioRepository.save(usuario);
    }

    public String login(LoginRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new CredenciaisInvalidasException("Email ou senha inválidos."));

        boolean senhaCorreta = passwordEncoder.matches(
                dto.getSenha(), usuario.getSenha()
        );

        if (!senhaCorreta) {
            throw new CredenciaisInvalidasException("Email ou senha inválidos.");

        }
        return tokenService.gerarToken(usuario);
    }
}
