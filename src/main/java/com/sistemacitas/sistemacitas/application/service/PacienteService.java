package com.sistemacitas.sistemacitas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemacitas.sistemacitas.application.ports.input.PacienteServicePort;
import com.sistemacitas.sistemacitas.application.ports.output.PacientePersistencePort;
import com.sistemacitas.sistemacitas.application.ports.output.PersonaPersistencePort;
import com.sistemacitas.sistemacitas.domain.exception.PacienteNotFoundException;
import com.sistemacitas.sistemacitas.domain.model.Paciente;
import com.sistemacitas.sistemacitas.domain.model.Persona;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService implements PacienteServicePort {
    private final PacientePersistencePort persistencePort;
    private final PersonaPersistencePort personaPersistencePort;

    @Override
    public Paciente getPaciente(Long id) {
        return persistencePort.getPaciente(id)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente no encontrado"));
    }

    @Override
    public List<Paciente> getPacientes() {
        return persistencePort.getPacientes();
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        Persona persona = new Persona();
        persona.setNombre(paciente.getPersona().getNombre());
        persona.setApellidos(paciente.getPersona().getApellidos());
        persona.setDni(paciente.getPersona().getDni());
        persona.setTelefono(paciente.getPersona().getTelefono());
        persona.setEmail(paciente.getPersona().getEmail());
        persona.setDireccion(paciente.getPersona().getDireccion());
        persona = personaPersistencePort.createPersona(persona);
        paciente.setPersona(persona);
        return persistencePort.createPaciente(paciente);
    }

    @Override
    public Paciente updatePaciente(Long id, Paciente paciente) {
        return persistencePort.getPaciente(id).map(existingPaciente -> {
            Persona persona = existingPaciente.getPersona();
            persona.setId(existingPaciente.getPersona().getId());
            persona.setNombre(paciente.getPersona().getNombre());
            persona.setApellidos(paciente.getPersona().getApellidos());
            persona.setDni(paciente.getPersona().getDni());
            persona.setTelefono(paciente.getPersona().getTelefono());
            persona.setEmail(paciente.getPersona().getEmail());
            persona.setDireccion(paciente.getPersona().getDireccion());
            Persona updatedPersona = personaPersistencePort.createPersona(persona);
            
            // Asignar la entidad Persona actualizada al Paciente
            existingPaciente.setPersona(updatedPersona);
            return persistencePort.createPaciente(existingPaciente);

        }).orElseThrow(() -> new PacienteNotFoundException("Paciente no encontrado"));
    }

    @Override
    public void deletePaciente(Long id) {
        if (persistencePort.getPaciente(id).isEmpty()) {
            throw new PacienteNotFoundException("Paciente no encontrado");
        }
        persistencePort.deletePaciente(id);
    }
}
