package com.arthur.secure_notes.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
