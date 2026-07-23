package com.arthur.secure_notes.exception;

public class NotaNaoEncontradaException extends RuntimeException {
    public NotaNaoEncontradaException(String mensagem){
        super(mensagem);

    }
}
