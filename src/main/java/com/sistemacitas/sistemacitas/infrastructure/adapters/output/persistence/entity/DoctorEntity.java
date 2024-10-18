package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "doctores")
public class DoctorEntity extends PersonaEntity {
    private LocalDateTime createdAt;
    private int flagEstado;

    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private EspecialidadEntity especialidad;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.flagEstado = 1;
    }
}
