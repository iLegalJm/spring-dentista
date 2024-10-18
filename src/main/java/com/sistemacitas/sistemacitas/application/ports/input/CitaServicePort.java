package com.sistemacitas.sistemacitas.application.ports.input;

import com.sistemacitas.sistemacitas.domain.model.Cita;

import java.util.List;

public interface CitaServicePort {
    public Cita getCita(Long id);

    public List<Cita> getCitas();

    public Cita createCita(Cita cita);

    public Cita updateCita(Long id, Cita cita);

    public void deleteCita(Long id);
}
