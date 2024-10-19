package com.sistemacitas.sistemacitas.application.ports.input;

import com.sistemacitas.sistemacitas.domain.model.Persona;

import java.util.List;

public interface PersonaServicePort {

    public Persona getPersona(Long id);

    public List<Persona> getPersonas();

    public Persona createPersona(Persona persona);

    public Persona updatePersona(Long id, Persona persona);

    public void deletePersona(Long id);

}
