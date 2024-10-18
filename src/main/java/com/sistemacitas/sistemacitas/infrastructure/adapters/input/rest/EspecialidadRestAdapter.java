package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemacitas.sistemacitas.application.ports.input.EspecialidadServicePort;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper.EspecialidadRestMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.EspecialidadCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.EspecialidadResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/especialidad")
public class EspecialidadRestAdapter {
    private final EspecialidadServicePort servicePort;
    private final EspecialidadRestMapper restMapper;

    @GetMapping("/v1/api")
    public List<EspecialidadResponse> buscarEspecialidades() {
        return restMapper.toEspecialidadResponseList(servicePort.getEspecialidades());
    }

    @GetMapping("/v1/api/{id}")
    public EspecialidadResponse buscar(@RequestParam Long id) {
        return restMapper.toEspecialidadResponse(servicePort.getEspecialidad(id));
    }

    @PostMapping("/v1/api")
    public ResponseEntity<EspecialidadResponse> guardar(@Valid @RequestBody EspecialidadCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper
                        .toEspecialidadResponse(servicePort.createEspecialidad(restMapper.toEspecialidad(request))));
    }

    @PutMapping("/v1/api/{id}")
    public ResponseEntity<EspecialidadResponse> actualizar(@PathVariable Long id,
            @Valid @RequestBody EspecialidadCreateRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(restMapper
                        .toEspecialidadResponse(
                                servicePort.updateEspecialidad(id, restMapper.toEspecialidad(request))));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicePort.deleteEspecialidad(id);
        return ResponseEntity.noContent().build();
    }
}
