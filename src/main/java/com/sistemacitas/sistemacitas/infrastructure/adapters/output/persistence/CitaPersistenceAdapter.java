package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sistemacitas.sistemacitas.application.ports.output.CitaPersistencePort;
import com.sistemacitas.sistemacitas.domain.model.Cita;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper.CitaPersistenceMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.CitaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CitaPersistenceAdapter implements CitaPersistencePort {

    private final CitaRepository citaRepository;
    private final CitaPersistenceMapper persistenceMapper;

    @Override
    public Optional<Cita> getCita(Long id) {
        return citaRepository.findById(id).map(persistenceMapper::toCita);
    }

    @Override
    public List<Cita> getCitas() {
        return persistenceMapper.toCitaList(citaRepository.findAll());
    }

    @Override
    public Cita createCita(Cita cita) {
        return persistenceMapper.toCita(citaRepository.save(persistenceMapper.toCitaEntity(cita)));
    }

    @Override
    public void deleteCita(Long id) {
        citaRepository.deleteById(id);
    }

}
