package com.sistemacitas.sistemacitas.application.ports.output;

import java.util.List;

import java.util.Optional;

import com.sistemacitas.sistemacitas.domain.model.Dentista;

public interface DentistaPersistencePort {
    Optional<Dentista> buscar(Long id);

    List<Dentista> buscarDentistas();

    Dentista guardar(Dentista dentista);

    void eliminar(Long id);
}
