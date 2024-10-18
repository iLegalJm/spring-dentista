package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sistemacitas.sistemacitas.application.ports.output.PacientePersistencePort;
import com.sistemacitas.sistemacitas.domain.model.Paciente;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper.PacientePersistenceMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.PacienteRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PacientePersistenceAdapter implements PacientePersistencePort {

    private final PacienteRepository pacienteRepository;

    private final PacientePersistenceMapper persistenceMapper;

    @Override
    public Optional<Paciente> getPaciente(Long id) {
        return pacienteRepository.findById(id).map(persistenceMapper::toPaciente);
    }

    @Override
    public List<Paciente> getPacientes() {
        return persistenceMapper.toPacienteList(pacienteRepository.findAll());
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        return persistenceMapper.toPaciente(pacienteRepository.save(persistenceMapper.toPacienteEntity(paciente)));
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

}
