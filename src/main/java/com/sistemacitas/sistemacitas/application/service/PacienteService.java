package com.sistemacitas.sistemacitas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemacitas.sistemacitas.application.ports.input.PacienteServicePort;
import com.sistemacitas.sistemacitas.application.ports.output.PacientePersistencePort;
import com.sistemacitas.sistemacitas.domain.exception.PacienteNotFoundException;
import com.sistemacitas.sistemacitas.domain.model.Paciente;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService implements PacienteServicePort {
    private final PacientePersistencePort persistencePort;

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
        return persistencePort.createPaciente(paciente);
    }

    @Override
    public Paciente updatePaciente(Long id, Paciente paciente) {
        return persistencePort.getPaciente(id).map(savePaciente -> {
            savePaciente.setId(savePaciente.getId());
            savePaciente.setNombre(paciente.getNombre());
            savePaciente.setApellidos(paciente.getApellidos());
            savePaciente.setDni(paciente.getDni());
            savePaciente.setTelefono(paciente.getTelefono());
            savePaciente.setEmail(paciente.getEmail());
            savePaciente.setDireccion(paciente.getDireccion());
            return persistencePort.createPaciente(savePaciente);
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
