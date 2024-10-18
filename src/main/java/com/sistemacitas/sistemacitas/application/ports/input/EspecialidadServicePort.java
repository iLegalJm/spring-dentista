package com.sistemacitas.sistemacitas.application.ports.input;

import com.sistemacitas.sistemacitas.domain.model.Especialidad;

import java.util.List;

public interface EspecialidadServicePort {
    public Especialidad getEspecialidad(Long id);

    public List<Especialidad> getEspecialidades();

    public Especialidad createEspecialidad(Especialidad especialidad);

    public Especialidad updateEspecialidad(Long id, Especialidad especialidad);

    public void deleteEspecialidad(Long id);
}
