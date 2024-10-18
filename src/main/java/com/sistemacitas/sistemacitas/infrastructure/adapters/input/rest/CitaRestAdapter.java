package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemacitas.sistemacitas.application.ports.input.CitaServicePort;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper.CitaRestMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.CitaCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.CitaResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cita")
public class CitaRestAdapter {
    private final CitaServicePort servicePort;
    private final CitaRestMapper restMapper;

    @GetMapping("/v1/api")
    public List<CitaResponse> buscarCitas() {
        return restMapper.toCitaResponseList(servicePort.getCitas());
    }

    @GetMapping("/v1/api/{id}")
    public CitaResponse buscar(Long id) {
        return restMapper.toCitaResponse(servicePort.getCita(id));
    }

    @PostMapping("/v1/api")
    public ResponseEntity<CitaResponse> guardar(@Valid @RequestBody CitaCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toCitaResponse(servicePort.createCita(restMapper.toCita(request))));
    }

    @PutMapping("/v1/api/{id}")
    public ResponseEntity<CitaResponse> actualizar(Long id, @Valid @RequestBody CitaCreateRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(restMapper.toCitaResponse(servicePort.updateCita(id, restMapper.toCita(request))));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<Void> eliminar(Long id) {
        servicePort.deleteCita(id);
        return ResponseEntity.noContent().build();
    }
}
