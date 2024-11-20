package com.sistemacitas.sistemacitas.application.ports.output;

import java.util.Optional;

import com.sistemacitas.sistemacitas.domain.model.Paciente;
import java.util.List;

public interface PacientePersistencePort {
    public Optional<Paciente> getPaciente(Long id);

    public Optional<Paciente> getPacienteByDni(String dni);

    public List<Paciente> getPacientes();
    
    public Paciente createPaciente(Paciente paciente);

    public void deletePaciente(Long id);
    
}
