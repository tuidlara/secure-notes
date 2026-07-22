package com.arthur.secure_notes.dto;

import jakarta.validation.constraints.NotBlank;

public class CriarNotaRequestDTO {

    @NotBlank(message = "Título não pode ser vazio.")
    private String titulo;

    @NotBlank(message = "Conteúdo não pode ser vazio.")
    private String conteudo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}