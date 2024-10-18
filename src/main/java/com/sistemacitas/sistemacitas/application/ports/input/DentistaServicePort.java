package com.sistemacitas.sistemacitas.application.ports.input;

import com.sistemacitas.sistemacitas.domain.model.Dentista;
import java.util.List;


public interface DentistaServicePort {
    Dentista buscar(Long id);
    List<Dentista> buscarDentistas();
    Dentista guardar(Dentista dentista);
    Dentista actualizar(Long id, Dentista dentista);
    void eliminar(Long id);
}
