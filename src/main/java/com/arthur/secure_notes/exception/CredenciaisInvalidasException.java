package com.arthur.secure_notes.exception;

public class CredenciaisInvalidasException extends RuntimeException {
    public CredenciaisInvalidasException(String mensagem){
        super(mensagem);
    }

}
