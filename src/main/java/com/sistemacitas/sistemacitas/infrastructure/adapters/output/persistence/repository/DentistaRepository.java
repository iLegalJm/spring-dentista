package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.DentistaEntity;

public interface DentistaRepository extends JpaRepository<DentistaEntity, Long> {

}
