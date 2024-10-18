package com.sistemacitas.sistemacitas.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorResponse {
    private String codigo;
    private String mensaje;
    private String detalle;
    private List<String> detalles;
    private LocalDateTime timestamp;
}
