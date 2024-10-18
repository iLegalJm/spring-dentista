package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sistemacitas.sistemacitas.application.ports.output.DentistaPersistencePort;
import com.sistemacitas.sistemacitas.domain.model.Dentista;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper.DentistaPersistenceMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.DentistaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DentistaPersistenceAdapter implements DentistaPersistencePort {

    private final DentistaRepository dentistaRepository;

    private final DentistaPersistenceMapper persistenceMapper;

    @Override
    public Optional<Dentista> buscar(Long id) {
        return dentistaRepository.findById(id).map(persistenceMapper::toDentista);
    }

    @Override
    public List<Dentista> buscarDentistas() {
        return persistenceMapper.toDentistaList(dentistaRepository.findAll());
    }

    @Override
    public Dentista guardar(Dentista dentista) {
        return persistenceMapper
                .toDentista(dentistaRepository.save(persistenceMapper.toDentistaEntity(dentista)));
    }

    @Override
    public void eliminar(Long id) {
        dentistaRepository.deleteById(id);
    }

}
