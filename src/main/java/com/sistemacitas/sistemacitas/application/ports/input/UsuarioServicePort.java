package com.sistemacitas.sistemacitas.application.ports.input;

import com.sistemacitas.sistemacitas.domain.model.Usuario;

public interface UsuarioServicePort {

    public Usuario obtenerUsuarioPorUsername(String username);

    public boolean login(String username, String password);

    public boolean logout();

    public Usuario register(Usuario usuario);
}
