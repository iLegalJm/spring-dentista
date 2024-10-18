package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper;

import com.sistemacitas.sistemacitas.domain.model.Cita;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.CitaEntity;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CitaPersistenceMapper {
    CitaEntity toCitaEntity(Cita cita);

    Cita toCita(CitaEntity citaEntity);

    List<Cita> toCitaList(List<CitaEntity> citaEntityList);

}
