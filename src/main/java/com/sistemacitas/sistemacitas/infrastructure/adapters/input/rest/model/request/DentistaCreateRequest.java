package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotEmpty;
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
public class DentistaCreateRequest {
    
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;  

    @NotEmpty(message = "Los apellidos no pueden estar vacíos")
    private String apellidos;


    @NotEmpty(message = "El DNI no puede estar vacío")
    private String dni;

    @NotEmpty(message = "El teléfono no puede estar vacío")
    private String telefono;

    @NotEmpty(message = "La especialidad no puede estar vacía")
    private String especialidad;

}
