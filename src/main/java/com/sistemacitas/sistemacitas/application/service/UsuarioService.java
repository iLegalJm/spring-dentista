package com.sistemacitas.sistemacitas.application.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistemacitas.sistemacitas.application.ports.input.UsuarioServicePort;
import com.sistemacitas.sistemacitas.application.ports.output.UsuarioPersistencePort;
import com.sistemacitas.sistemacitas.domain.model.Usuario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class UsuarioService implements UsuarioServicePort, UserDetailsService {
    private final UsuarioPersistencePort usuarioPersistencePort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Usuario obtenerUsuarioPorUsername(String username) {
        return usuarioPersistencePort.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public boolean login(String username, String password) {
        Usuario usuario = usuarioPersistencePort.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return passwordEncoder.matches(password, usuario.getPassword());
    }

    @Override
    public boolean logout() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }

    @Override
    public Usuario register(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioPersistencePort.createUsuario(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = obtenerUsuarioPorUsername(username);
        return new User(usuario.getUsername(), usuario.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(usuario.getRole())));
    }
}
