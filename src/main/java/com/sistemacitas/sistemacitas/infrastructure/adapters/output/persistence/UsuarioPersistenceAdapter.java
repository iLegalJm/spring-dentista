package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sistemacitas.sistemacitas.application.ports.output.UsuarioPersistencePort;
import com.sistemacitas.sistemacitas.domain.model.Usuario;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper.UsuarioPersistenceMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioPersistenceAdapter implements UsuarioPersistencePort {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioPersistenceMapper persistenceMapper;

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username).map(persistenceMapper::toUsuario);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return persistenceMapper.toUsuario(usuarioRepository.save(persistenceMapper.toUsuarioEntity(usuario)));
    }

}
