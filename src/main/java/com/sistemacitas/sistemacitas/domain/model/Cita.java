package com.sistemacitas.sistemacitas.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    private Long id;
    private Doctor doctor;
    private Paciente paciente;
    private String serie;
    private int numero;
    private LocalDateTime fecha;
    private String motivo;
    private LocalDateTime createdAt;
    private int flagEstado;
}
