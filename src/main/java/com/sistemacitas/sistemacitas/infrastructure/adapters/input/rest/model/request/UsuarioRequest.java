package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UsuarioRequest {
    private String username;
    private String password;
    private Long persona;
}
