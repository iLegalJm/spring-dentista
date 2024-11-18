package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemacitas.sistemacitas.application.ports.input.DoctorServicePort;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper.DoctorRestMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.DoctorCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.DoctorResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorRestAdapter {
    private final DoctorServicePort servicePort;
    private final DoctorRestMapper restMapper;

    @GetMapping("/v1/api")
    public List<DoctorResponse> buscarDoctores() {
        return restMapper.toDoctorResponseList(servicePort.getDoctors());
    }

    @GetMapping("/v1/api/{id}")
    public DoctorResponse buscar(@PathVariable Long id) {
        System.out.println(restMapper.toDoctorResponse(servicePort.getDoctor(id)));
        return restMapper.toDoctorResponse(servicePort.getDoctor(id));
    }

    @PostMapping("/v1/api")
    public DoctorResponse guardar(@Valid @RequestBody DoctorCreateRequest request) {
        return restMapper.toDoctorResponse(servicePort.createDoctor(restMapper.toDoctor(request)));
    }

    @PutMapping("/v1/api/{id}")
    public DoctorResponse actualizar(Long id, @Valid @RequestBody DoctorCreateRequest request) {
        return restMapper.toDoctorResponse(servicePort.updateDoctor(id, restMapper.toDoctor(request)));
    }

    @DeleteMapping("/v1/api/{id}")
    public void eliminar(Long id) {
        servicePort.deleteDoctor(id);
    }

}
