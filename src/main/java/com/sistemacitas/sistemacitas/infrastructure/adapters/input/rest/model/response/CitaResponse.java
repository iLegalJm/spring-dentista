package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitaResponse {
    private Long id;
    private PacienteResponse paciente;
    private DoctorResponse doctor;
    private String fecha;
    private String motivo;
    private String serie;
    private int numero;
    private LocalDateTime created_at;
    private int flag_estado;
}
