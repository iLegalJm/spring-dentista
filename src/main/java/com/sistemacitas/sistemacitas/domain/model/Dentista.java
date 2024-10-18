package com.sistemacitas.sistemacitas.domain.model;

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
public class Dentista {
    private Long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String email;
    private String direccion;
    private String especialidad;
}
