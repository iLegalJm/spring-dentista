package com.sistemacitas.sistemacitas.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private Long id;
    private Persona persona;
    private LocalDateTime createdAt;
    private int flagEstado;
    private Especialidad especialidad;
}
