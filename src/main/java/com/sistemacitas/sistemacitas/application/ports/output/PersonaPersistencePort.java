package com.sistemacitas.sistemacitas.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.sistemacitas.sistemacitas.domain.model.Persona;

public interface PersonaPersistencePort {
    Optional<Persona> getPersona(Long id);

    List<Persona> getPersonas();

    Persona createPersona(Persona persona);

    void deletePersona(Long id);
}
