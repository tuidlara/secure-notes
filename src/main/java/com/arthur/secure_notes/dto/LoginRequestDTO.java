package com.arthur.secure_notes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {

    @Email(message = "Email inválido.")
    @NotBlank(message = "Email não pode ser vazio.")
    private String email;

    @NotBlank(message = "Senha não pode ser vazia.")
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}