package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper;

import com.sistemacitas.sistemacitas.domain.model.Especialidad;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.EspecialidadCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.EspecialidadResponse;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface EspecialidadRestMapper {
    Especialidad toEspecialidad(EspecialidadCreateRequest request);

    EspecialidadResponse toEspecialidadResponse(Especialidad especialidad);

    List<EspecialidadResponse> toEspecialidadResponseList(List<Especialidad> especialidadList);
}
