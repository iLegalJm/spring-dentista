package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response;

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
    private String fecha;
    private String motivo;
    private PacienteResponse paciente;
    private DoctorResponse doctor;
}
