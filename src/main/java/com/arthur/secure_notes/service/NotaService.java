package com.arthur.secure_notes.service;

import com.arthur.secure_notes.dto.CriarNotaRequestDTO;
import com.arthur.secure_notes.dto.NotaResponseDTO;
import com.arthur.secure_notes.entity.Nota;
import com.arthur.secure_notes.entity.Usuario;
import com.arthur.secure_notes.repository.NotaRepository;
import com.arthur.secure_notes.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final UsuarioRepository usuarioRepository;

    public NotaService(
            NotaRepository notaRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.notaRepository = notaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void criarNota(CriarNotaRequestDTO dto, String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Nota nota = new Nota(
                dto.getTitulo(),
                dto.getConteudo(),
                usuario
        );

        notaRepository.save(nota);
    }

    public List<NotaResponseDTO> listarNotas(String email) {
        return notaRepository.findByUsuarioEmail(email)
                .stream()
                .map(NotaResponseDTO::new)
                .toList();
    }

    public NotaResponseDTO listarNotaPorId(Long id, String email) {
        Nota nota = notaRepository.findByIdAndUsuarioEmail(id, email)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada."));
        return new NotaResponseDTO(nota);
    }

}