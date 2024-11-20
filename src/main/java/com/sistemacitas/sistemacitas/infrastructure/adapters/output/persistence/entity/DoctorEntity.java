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
    
    @ManyToOne
    @JoinColumn(name = "especialidad_id", referencedColumnName = "id")
    private EspecialidadEntity especialidad;
    
    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private PersonaEntity persona;
    
    private LocalDateTime created_at;
    private int flag_estado;

    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
        this.flag_estado = 1;
    }
}
