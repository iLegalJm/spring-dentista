package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.sistemacitas.sistemacitas.domain.model.Dentista;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.DentistaCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.DentistaResponse;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DentistaRestMapper {
    Dentista toDentista(DentistaCreateRequest request);

    DentistaResponse toDentistaResponse(Dentista dentista);

    List<DentistaResponse> toDentistaResponseList(List<Dentista> dentistaList);
}
