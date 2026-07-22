package com.arthur.secure_notes.dto;

import com.arthur.secure_notes.entity.Nota;

public class NotaResponseDTO {

    private Long id;
    private String titulo;
    private String conteudo;

    public NotaResponseDTO(Nota nota) {
        this.id = nota.getId();
        this.titulo = nota.getTitulo();
        this.conteudo = nota.getConteudo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

