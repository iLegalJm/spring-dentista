package com.sistemacitas.sistemacitas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemacitas.sistemacitas.application.ports.input.DentistaServicePort;
import com.sistemacitas.sistemacitas.application.ports.output.DentistaPersistencePort;
import com.sistemacitas.sistemacitas.domain.exception.DentistaNotFoundException;
import com.sistemacitas.sistemacitas.domain.model.Dentista;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DentistaService implements DentistaServicePort {

    private final DentistaPersistencePort persistencePort;

    @Override
    public Dentista buscar(Long id) {
        return persistencePort.buscar(id).orElseThrow(DentistaNotFoundException::new);
    }

    @Override
    public List<Dentista> buscarDentistas() {
        return persistencePort.buscarDentistas();
    }

    @Override
    public Dentista guardar(Dentista dentista) {
        return persistencePort.guardar(dentista);
    }

    @Override
    public Dentista actualizar(Long id, Dentista dentista) {
        return persistencePort.buscar(
                id).map(
                        saveDentista -> {
                            saveDentista.setId(saveDentista.getId());
                            saveDentista.setNombre(dentista.getNombre());
                            saveDentista.setApellidos(dentista.getApellidos());
                            saveDentista.setDni(dentista.getDni());
                            saveDentista.setTelefono(dentista.getTelefono());
                            saveDentista.setEmail(dentista.getEmail());
                            saveDentista.setDireccion(dentista.getDireccion());
                            saveDentista.setEspecialidad(dentista.getEspecialidad());
                            return persistencePort.guardar(saveDentista);
                        })
                .orElseThrow(DentistaNotFoundException::new);
    }

    @Override
    public void eliminar(Long id) {
        if (persistencePort.buscar(id).isEmpty()) {
            throw new DentistaNotFoundException();
        }
        persistencePort.eliminar(id);
    }

}
