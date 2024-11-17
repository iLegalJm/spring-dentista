package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper;

import com.sistemacitas.sistemacitas.domain.model.Paciente;
import com.sistemacitas.sistemacitas.domain.model.Persona;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.PacienteCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.PacienteResponse;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface PacienteRestMapper {
    @Mapping(target = "persona.nombre", source = "nombre")
    @Mapping(target = "persona.apellidos", source = "apellidos")
    @Mapping(target = "persona.dni", source = "dni")
    @Mapping(target = "persona.telefono", source = "telefono")
    @Mapping(target = "persona.email", source = "email")
    @Mapping(target = "persona.direccion", source = "direccion")
    Paciente toPaciente(PacienteCreateRequest request);

    PacienteResponse toPacienteResponse(Paciente paciente);

    List<PacienteResponse> toPacienteResponseList(List<Paciente> pacienteList);

    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellidos", source = "apellidos")
    @Mapping(target = "dni", source = "dni")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "direccion", source = "direccion")
    Persona toPersona(PacienteCreateRequest request);
}
