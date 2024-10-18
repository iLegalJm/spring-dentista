package com.sistemacitas.sistemacitas.domain.exception;

public class PacienteNotFoundException extends RuntimeException {
    public PacienteNotFoundException(String message) {
        super(message);
    }

}
