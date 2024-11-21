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
public class Usuario {
    private Long id;
    private String username;
    private String password;
    private String role;
    private Persona persona;
}
