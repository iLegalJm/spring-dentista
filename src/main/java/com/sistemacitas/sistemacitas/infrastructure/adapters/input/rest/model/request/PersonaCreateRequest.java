package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PersonaCreateRequest {
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellidos;
    @NotEmpty
    private String dni;
    @NotEmpty
    private String telefono;
    @NotEmpty
    private String email;
    @NotEmpty
    private String direccion;
}
