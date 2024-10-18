package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper;

import com.sistemacitas.sistemacitas.domain.model.Especialidad;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.EspecialidadEntity;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EspecialidadPersistenceMapper {
    EspecialidadEntity toEspecialidadEntity(Especialidad especialidad);

    Especialidad toEspecialidad(EspecialidadEntity especialidadEntity);

    List<Especialidad> toEspecialidadList(List<EspecialidadEntity> especialidadEntityList);
}
