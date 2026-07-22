package com.arthur.secure_notes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @GetMapping
    public String listarNotas() {
        return "Você está autenticado e pode acessar suas notas";
    }
}