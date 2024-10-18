package com.sistemacitas.sistemacitas.domain.exception;

public class DotorNotFoundException extends RuntimeException {
    public DotorNotFoundException(String messsage) {
        super(messsage);
    }
}
