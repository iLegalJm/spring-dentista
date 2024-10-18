package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "pacientes")
public class PacienteEntity extends PersonaEntity {
    private LocalDateTime createdAt;
    private int flagEstado;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.flagEstado = 1;
    }
}
