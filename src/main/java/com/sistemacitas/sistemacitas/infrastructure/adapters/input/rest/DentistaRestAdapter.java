package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemacitas.sistemacitas.application.ports.input.DentistaServicePort;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper.DentistaRestMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.DentistaCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.DentistaResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor
@RequestMapping("/dentista")
public class DentistaRestAdapter {
    private final DentistaServicePort servicePort;
    private final DentistaRestMapper restMapper;

    @GetMapping("/v1/api")
    public List<DentistaResponse> buscarDentistas() {
        return restMapper.toDentistaResponseList(servicePort.buscarDentistas());
    }

    @GetMapping("/v1/api/{id}")
    public DentistaResponse buscar(@PathVariable Long id) {
        return restMapper.toDentistaResponse(servicePort.buscar(id));
    }

    @PostMapping("/v1/api")
    public ResponseEntity<DentistaResponse> guardar(@Valid @RequestBody DentistaCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toDentistaResponse(servicePort.guardar(restMapper.toDentista(request))));
    }

    @PutMapping("/v1/api/{id}")
    public ResponseEntity<DentistaResponse> actualizar(@PathVariable Long id, @Valid @RequestBody DentistaCreateRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(restMapper.toDentistaResponse(servicePort.actualizar(id, restMapper.toDentista(request))));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicePort.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
