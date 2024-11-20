package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request;

import java.time.LocalDateTime;

// import jakarta.validation.constraints.Min;
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

    // @NotNull(message = "El paciente no puede estar vacío")
    private Long paciente;

    // @Min(value = 8, message = "El DNI del paciente debe tener 8 dígitos")
    private String dni;

    // @NotNull(message = "El doctor no puede estar vacío")
    private Long doctor;

    @NotEmpty(message = "El motivo no puede estar vacío")
    private String motivo;

    private String serie;
    private int numero;
    private LocalDateTime created_at;
    private int flag_estado;
}
