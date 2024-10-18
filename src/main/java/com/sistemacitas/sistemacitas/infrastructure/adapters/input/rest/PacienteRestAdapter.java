package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest;

import org.springframework.web.bind.annotation.RestController;

import com.sistemacitas.sistemacitas.application.ports.input.PacienteServicePort;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper.PacienteRestMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.PacienteCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.PacienteResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteRestAdapter {
    private final PacienteServicePort servicePort;
    private final PacienteRestMapper restMapper;

    @GetMapping("/v1/api")
    public List<PacienteResponse> buscarPacientes() {
        return restMapper.toPacienteResponseList(servicePort.getPacientes());
    }

    @GetMapping("/v1/api/{id}")
    public PacienteResponse buscar(@RequestParam Long id) {
        return restMapper.toPacienteResponse(servicePort.getPaciente(id));
    }

    @PostMapping("/v1/api")
    public ResponseEntity<PacienteResponse> guardar(@Valid @RequestBody PacienteCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toPacienteResponse(servicePort.createPaciente(restMapper.toPaciente(request))));
    }

    @PutMapping("/v1/api/{id}")
    public ResponseEntity<PacienteResponse> actualizar(@PathVariable Long id,
            @Valid @RequestBody PacienteCreateRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(restMapper.toPacienteResponse(servicePort.updatePaciente(id, restMapper.toPaciente(request))));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicePort.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

}
