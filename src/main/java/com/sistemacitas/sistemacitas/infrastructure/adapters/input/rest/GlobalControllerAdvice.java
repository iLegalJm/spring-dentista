package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sistemacitas.sistemacitas.domain.exception.DentistaNotFoundException;
import com.sistemacitas.sistemacitas.domain.model.ErrorResponse;
import com.sistemacitas.sistemacitas.utils.CatalogoErrores;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.Collections;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DentistaNotFoundException.class)
    public ErrorResponse handleDentistaNotFoundException() {
        return ErrorResponse.builder()
                .codigo(CatalogoErrores.DENTISTA_NO_ENCONTRADO.getCodigo())
                .mensaje(CatalogoErrores.DENTISTA_NO_ENCONTRADO.getMensaje())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        BindingResult result = ex.getBindingResult();

        return ErrorResponse.builder()
                .codigo(CatalogoErrores.DENTISTA_INVALIDO.getCodigo())
                .mensaje(CatalogoErrores.DENTISTA_INVALIDO.getMensaje())
                .detalles(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception ex) {
        return ErrorResponse.builder()
                .codigo(CatalogoErrores.ERROR_GENERICO.getCodigo())
                .mensaje(CatalogoErrores.ERROR_GENERICO.getMensaje())
                .detalles(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

}
