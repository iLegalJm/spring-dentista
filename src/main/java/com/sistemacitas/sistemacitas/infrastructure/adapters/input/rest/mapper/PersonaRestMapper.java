package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;

import com.sistemacitas.sistemacitas.domain.model.Persona;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.PersonaCreateRequest;

@Mapper(componentModel = "spring")
public interface PersonaRestMapper {
    Persona toPersona(PersonaCreateRequest request);

    PersonaCreateRequest toPersonaCreateRequest(Persona persona);
}
