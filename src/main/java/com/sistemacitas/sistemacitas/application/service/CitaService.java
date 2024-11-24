package com.sistemacitas.sistemacitas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemacitas.sistemacitas.application.ports.input.CitaServicePort;
import com.sistemacitas.sistemacitas.application.ports.output.CitaPersistencePort;
import com.sistemacitas.sistemacitas.application.ports.output.PacientePersistencePort;
import com.sistemacitas.sistemacitas.application.ports.output.PersonaPersistencePort;
import com.sistemacitas.sistemacitas.domain.exception.CitaNotFoundException;
import com.sistemacitas.sistemacitas.domain.model.Cita;
import com.sistemacitas.sistemacitas.domain.model.Paciente;
import com.sistemacitas.sistemacitas.domain.model.Persona;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitaService implements CitaServicePort {

    private final CitaPersistencePort persistencePort;
    private final PacientePersistencePort pacientePersistencePort;
    private final PersonaPersistencePort personaPersistencePort;

    @Override
    public Cita getCita(Long id) {
        return persistencePort.getCita(id).orElseThrow(() -> new CitaNotFoundException("Cita no encontrada"));
    }

    @Override
    public List<Cita> getCitas() {
        return persistencePort.getCitas();
    }

    @Override
    public Cita createCita(Cita cita) {
        return persistencePort.createCita(cita);
    }

    @Override
    public Cita updateCita(Long id, Cita cita) {
        return persistencePort.getCita(id).map(saveCita -> {
            saveCita.setId(saveCita.getId());
            saveCita.setFecha(cita.getFecha());
            saveCita.setPaciente(cita.getPaciente());
            saveCita.setDoctor(cita.getDoctor());
            return persistencePort.createCita(saveCita);
        }).orElseThrow(() -> new CitaNotFoundException("Cita no encontrada"));
    }

    @Override
    public void deleteCita(Long id) {
        if (persistencePort.getCita(id).isEmpty()) {
            throw new CitaNotFoundException("Cita no encontrada");
        }
        persistencePort.deleteCita(id);
    }

    @Override
    public Cita createCitaByDni(String dni, Cita cita) {
        Paciente paciente = pacientePersistencePort.getPacienteByDni(dni)
                .orElseGet(() -> {

                    Persona nuevaPersona = new Persona();
                    nuevaPersona.setDni(dni);
                    nuevaPersona.setNombre("Por definir");
                    nuevaPersona.setApellidos("Por definir");
                    nuevaPersona.setDireccion("Por definir");
                    nuevaPersona.setEmail("");
                    nuevaPersona.setTelefono("");

                    Persona personaGurdada = personaPersistencePort.createPersona(nuevaPersona);
                    System.out.println(personaGurdada);
                    Paciente nuevoPaciente = new Paciente();
                    nuevoPaciente.setPersona(personaGurdada);
                    return pacientePersistencePort.createPaciente(nuevoPaciente);
                });
        cita.setPaciente(paciente);
        return persistencePort.createCita(cita);
    }

}
