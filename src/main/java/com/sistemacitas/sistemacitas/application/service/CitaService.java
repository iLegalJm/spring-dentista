package com.sistemacitas.sistemacitas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemacitas.sistemacitas.application.ports.input.CitaServicePort;
import com.sistemacitas.sistemacitas.application.ports.output.CitaPersistencePort;
import com.sistemacitas.sistemacitas.domain.exception.CitaNotFoundException;
import com.sistemacitas.sistemacitas.domain.model.Cita;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitaService implements CitaServicePort {

    private final CitaPersistencePort persistencePort;

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

}
