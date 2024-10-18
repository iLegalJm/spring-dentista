package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class CitaCreateRequest {

    @NotEmpty(message = "La fecha no puede estar vacía")
    private String fecha;

    @NotNull(message = "El paciente no puede estar vacío")
    private Long pacienteId;

    @NotNull(message = "El dentista no puede estar vacío")
    private Long dentistaId;

    @NotEmpty(message = "El motivo no puede estar vacío")
    private String motivo;

}
