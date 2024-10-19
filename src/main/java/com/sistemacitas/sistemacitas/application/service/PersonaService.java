package com.sistemacitas.sistemacitas.application.service;

import org.springframework.stereotype.Service;

import com.sistemacitas.sistemacitas.application.ports.input.PersonaServicePort;
import com.sistemacitas.sistemacitas.application.ports.output.PersonaPersistencePort;
import com.sistemacitas.sistemacitas.domain.exception.PersonaFoundException;
import com.sistemacitas.sistemacitas.domain.model.Persona;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService implements PersonaServicePort {

    private final PersonaPersistencePort persistencePort;

    @Override
    public List<Persona> getPersonas() {
        return persistencePort.getPersonas();
    }

    @Override
    public Persona getPersona(Long id) {
        return persistencePort.getPersona(id).orElseThrow(() -> new PersonaFoundException("Persona no encontrada"));
    }

    @Override
    public Persona createPersona(Persona persona) {
        return persistencePort.createPersona(persona);
    }

    @Override
    public Persona updatePersona(Long id, Persona persona) {
        return persistencePort.getPersona(id).map(savePersona -> {
            savePersona.setId(savePersona.getId());
            savePersona.setNombre(persona.getNombre());
            savePersona.setApellidos(persona.getApellidos());
            savePersona.setDni(persona.getDni());
            savePersona.setTelefono(persona.getTelefono());
            savePersona.setEmail(persona.getEmail());
            savePersona.setDireccion(persona.getDireccion());
            return persistencePort.createPersona(savePersona);
        }).orElseThrow(() -> new PersonaFoundException("Persona no encontrada"));
    }

    @Override
    public void deletePersona(Long id) {
        if (persistencePort.getPersona(id).isEmpty()) {
            throw new PersonaFoundException("Persona no encontrada");
        }
        persistencePort.deletePersona(id);
    }
}
