package com.arthur.secure_notes.controller;

import com.arthur.secure_notes.dto.CriarNotaRequestDTO;
import com.arthur.secure_notes.dto.NotaResponseDTO;
import com.arthur.secure_notes.entity.Nota;
import com.arthur.secure_notes.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping
    public String criarNota(
            @Valid @RequestBody CriarNotaRequestDTO dto,
            Authentication authentication
    ) {
        String email = authentication.getName();

        notaService.criarNota(dto, email);
        return "Nota criada com sucesso";
    }

    @GetMapping
    public List<NotaResponseDTO> listarNotas(Authentication authentication) {
        String email = authentication.getName();

        return notaService.listarNotas(email);
    }
}