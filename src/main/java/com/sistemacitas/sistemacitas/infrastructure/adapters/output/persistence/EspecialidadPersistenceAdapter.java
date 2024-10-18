package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sistemacitas.sistemacitas.application.ports.output.EspecialidadPersistencePort;
import com.sistemacitas.sistemacitas.domain.model.Especialidad;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper.EspecialidadPersistenceMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.EspecialidadRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EspecialidadPersistenceAdapter implements EspecialidadPersistencePort {

    private final EspecialidadRepository especialidadRepository;
    private final EspecialidadPersistenceMapper persistenceMapper;

    @Override
    public Optional<Especialidad> getEspecialidad(Long id) {
        return especialidadRepository.findById(id).map(persistenceMapper::toEspecialidad);
    }

    @Override
    public List<Especialidad> getEspecialidades() {
        return persistenceMapper.toEspecialidadList(especialidadRepository.findAll());
    }

    @Override
    public Especialidad createEspecialidad(Especialidad especialidad) {
        return persistenceMapper
                .toEspecialidad(especialidadRepository.save(persistenceMapper.toEspecialidadEntity(especialidad)));
    }

    @Override
    public void deleteEspecialidad(Long id) {
        especialidadRepository.deleteById(id);
    }

}
