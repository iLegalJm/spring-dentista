package com.sistemacitas.sistemacitas.application.ports.output;

import java.util.Optional;
import java.util.List;

import com.sistemacitas.sistemacitas.domain.model.Cita;

public interface CitaPersistencePort {
    public Optional<Cita> getCita(Long id);

    public List<Cita> getCitas();

    public Cita createCita(Cita cita);

    public void deleteCita(Long id);
}
