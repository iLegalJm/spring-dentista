package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.CitaEntity;

public interface CitaRepository extends JpaRepository<CitaEntity, Long> {
    
}
