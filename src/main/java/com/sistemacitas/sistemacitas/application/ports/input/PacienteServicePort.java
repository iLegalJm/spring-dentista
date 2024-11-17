package com.sistemacitas.sistemacitas.application.ports.input;

import com.sistemacitas.sistemacitas.domain.model.Paciente;
import com.sistemacitas.sistemacitas.domain.model.Persona;

import java.util.List;

public interface PacienteServicePort {
    public Paciente getPaciente(Long id);

    public List<Paciente> getPacientes();

    public Paciente createPaciente(Paciente paciente);

    public Paciente updatePaciente(Long id, Paciente paciente);

    public void deletePaciente(Long id);

    public Persona createPersona(Persona persona);
}
