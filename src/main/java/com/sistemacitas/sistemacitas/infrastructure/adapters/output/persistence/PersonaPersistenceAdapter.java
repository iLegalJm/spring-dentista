package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sistemacitas.sistemacitas.application.ports.output.PersonaPersistencePort;
import com.sistemacitas.sistemacitas.domain.model.Persona;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper.PersonaPersistenceMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.PersonaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonaPersistenceAdapter implements PersonaPersistencePort {

    private final PersonaRepository personaRepository;

    private final PersonaPersistenceMapper persistenceMapper;

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaRepository.findById(id).map(persistenceMapper::toPersona);
    }

    @Override
    public Persona createPersona(Persona persona) {
        return persistenceMapper.toPersona(personaRepository.save(persistenceMapper.toPersonaEntity(persona)));
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

}
