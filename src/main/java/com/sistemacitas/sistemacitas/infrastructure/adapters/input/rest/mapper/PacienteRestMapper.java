package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper;

import com.sistemacitas.sistemacitas.domain.model.Paciente;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.PacienteCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.PacienteResponse;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface PacienteRestMapper {
    Paciente toPaciente(PacienteCreateRequest request);

    PacienteResponse toPacienteResponse(Paciente paciente);

    List<PacienteResponse> toPacienteResponseList(List<Paciente> pacienteList);
}
