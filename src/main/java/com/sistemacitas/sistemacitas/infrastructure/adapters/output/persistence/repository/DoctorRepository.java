package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

}
