package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctores")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private int flagEstado;

    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private EspecialidadEntity especialidad;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private PersonaEntity persona;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.flagEstado = 1;
    }
}
