package com.sistemacitas.sistemacitas.application.ports.output;

import java.util.List;
import java.util.Optional;
import com.sistemacitas.sistemacitas.domain.model.Especialidad;

public interface EspecialidadPersistencePort {
    Optional<Especialidad> getEspecialidad(Long id);

    List<Especialidad> getEspecialidades();

    Especialidad createEspecialidad(Especialidad especialidad);

    void deleteEspecialidad(Long id);
}
