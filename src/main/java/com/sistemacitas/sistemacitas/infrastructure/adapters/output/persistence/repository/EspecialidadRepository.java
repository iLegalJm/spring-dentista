package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.EspecialidadEntity;

public interface EspecialidadRepository extends JpaRepository<EspecialidadEntity, Long> {
    
}
