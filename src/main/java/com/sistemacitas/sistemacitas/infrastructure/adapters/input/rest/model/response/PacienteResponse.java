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
public class PacienteResponse {
    private Long id;
    private PersonaResponse persona;
    private String created_at;
    private int flag_estado;
}
