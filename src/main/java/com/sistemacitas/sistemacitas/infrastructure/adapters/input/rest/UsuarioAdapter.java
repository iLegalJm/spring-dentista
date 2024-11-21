package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemacitas.sistemacitas.application.ports.input.UsuarioServicePort;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper.UsuarioRestMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.UsuarioRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.UsuarioResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioAdapter {
    private final UsuarioServicePort servicePort;
    private final UsuarioRestMapper restMapper;

    @PostMapping("/v1/api")
    public ResponseEntity<UsuarioResponse> guardar(@RequestBody UsuarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toUsuarioResponse(servicePort.register(restMapper.toUsuario(request))));
    }

    @PostMapping("/v1/api/login")
    public ResponseEntity<Void> login(@RequestBody UsuarioRequest request) {
        if (servicePort.login(request.getUsername(), request.getPassword())) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/logout")
    public boolean logout() {
        return servicePort.logout();
    }
}
