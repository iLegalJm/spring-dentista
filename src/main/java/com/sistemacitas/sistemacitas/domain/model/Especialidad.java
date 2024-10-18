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
public class Especialidad {

    private Long id;
    private String nombre;
    private String descripcion;
    private int flagEstado;
}
