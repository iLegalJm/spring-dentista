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
public class DentistaResponse {
    private Long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String email;
    private String direccion;
    private String especialidad;
}
