package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;

import com.sistemacitas.sistemacitas.domain.model.Persona;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.PersonaEntity;

@Mapper(componentModel = "spring")
public interface PersonaPersistenceMapper {
    PersonaEntity toPersonaEntity(Persona persona);

    Persona toPersona(PersonaEntity personaEntity);
}
