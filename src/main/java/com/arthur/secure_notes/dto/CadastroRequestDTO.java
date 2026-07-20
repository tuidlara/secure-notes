package com.arthur.secure_notes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CadastroRequestDTO {

    @Email(message = "Email inválido.")
    @NotBlank(message = "Email não pode ser vazio.")
    private String email;

    @NotBlank(message = "Senha não pode ser vazia.")
    @Size(min = 8, message = "Senha deve conter no mínimo 8 caracteres.")
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

