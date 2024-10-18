package com.sistemacitas.sistemacitas.domain.exception;

public class DentistaNotFoundException extends RuntimeException {
    public DentistaNotFoundException() {
        super("Dentista  no encontrado");
    }
}
