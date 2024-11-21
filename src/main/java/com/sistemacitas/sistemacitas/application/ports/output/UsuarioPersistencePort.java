package com.sistemacitas.sistemacitas.application.ports.output;

import java.util.Optional;

import com.sistemacitas.sistemacitas.domain.model.Usuario;

public interface UsuarioPersistencePort {    
    public Optional<Usuario> findByUsername(String username);

    public Usuario createUsuario(Usuario usuario);
}
