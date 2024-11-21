package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsername(String username);
}
