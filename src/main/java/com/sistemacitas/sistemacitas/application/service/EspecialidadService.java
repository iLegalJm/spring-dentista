package com.sistemacitas.sistemacitas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemacitas.sistemacitas.application.ports.input.EspecialidadServicePort;
import com.sistemacitas.sistemacitas.application.ports.output.EspecialidadPersistencePort;
import com.sistemacitas.sistemacitas.domain.exception.EspecialidadNotFoundException;
import com.sistemacitas.sistemacitas.domain.model.Especialidad;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EspecialidadService implements EspecialidadServicePort {

    private final EspecialidadPersistencePort persistencePort;

    @Override
    public Especialidad getEspecialidad(Long id) {
        return persistencePort.getEspecialidad(id)
                .orElseThrow(() -> new EspecialidadNotFoundException("Especialidad no encontrada"));
    }

    @Override
    public List<Especialidad> getEspecialidades() {
        return persistencePort.getEspecialidades();
    }

    @Override
    public Especialidad createEspecialidad(Especialidad especialidad) {
        return persistencePort.createEspecialidad(especialidad);
    }

    @Override
    public Especialidad updateEspecialidad(Long id, Especialidad especialidad) {
        return persistencePort.getEspecialidad(id).map(saveEspecialidad -> {
            saveEspecialidad.setId(saveEspecialidad.getId());
            saveEspecialidad.setNombre(especialidad.getNombre());
            saveEspecialidad.setDescripcion(especialidad.getDescripcion());
            return persistencePort.createEspecialidad(saveEspecialidad);
        }).orElseThrow(() -> new EspecialidadNotFoundException("Especialidad no encontrada"));
    }

    @Override
    public void deleteEspecialidad(Long id) {
        if (persistencePort.getEspecialidad(id).isEmpty()) {
            throw new EspecialidadNotFoundException("Especialidad no encontrada");
        }
        persistencePort.deleteEspecialidad(id);
    }

}
