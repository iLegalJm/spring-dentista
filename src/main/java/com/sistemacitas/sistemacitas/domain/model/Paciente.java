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
public class Paciente {
    private Long id;
    private Persona persona;
    private LocalDateTime createdAt;
    private int flagEstado;
}
