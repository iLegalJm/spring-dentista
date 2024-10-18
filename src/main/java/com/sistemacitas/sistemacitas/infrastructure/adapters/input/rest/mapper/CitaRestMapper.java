package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper;

import com.sistemacitas.sistemacitas.domain.model.Cita;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.CitaCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.CitaResponse;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CitaRestMapper {
    Cita toCita(CitaCreateRequest request);

    CitaResponse toCitaResponse(Cita cita);

    List<CitaResponse> toCitaResponseList(List<Cita> citaList);
}
