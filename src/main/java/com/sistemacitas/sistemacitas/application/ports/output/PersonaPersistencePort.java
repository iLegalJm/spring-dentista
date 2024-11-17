package com.sistemacitas.sistemacitas.application.ports.output;

import java.util.Optional;

import com.sistemacitas.sistemacitas.domain.model.Persona;

public interface PersonaPersistencePort {
    public Optional<Persona> getPersona(Long id);

    // public List<Persona> getPersonas();

    public Persona createPersona(Persona persona);

    public void deletePersona(Long id);
}
