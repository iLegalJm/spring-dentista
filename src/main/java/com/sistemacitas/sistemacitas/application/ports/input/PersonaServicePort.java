package com.sistemacitas.sistemacitas.application.ports.input;


import com.sistemacitas.sistemacitas.domain.model.Persona;

public interface PersonaServicePort {
    // public List<Persona> getPersonas();

    public Persona getPersona(Long id);

    public Persona createPersona(Persona persona);

    public Persona updatePersona(Long id, Persona persona);

    public void deletePersona(Long id);
}
