package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "citas")
public class CitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private PacienteEntity paciente;

    private String serie;
    private int numero;
    private LocalDateTime fecha;
    private String motivo;
    private LocalDateTime created_at;
    private int flag_estado;

    @PrePersist
    protected void onCreate() {
        this.serie = generateSerie(); // Método para generar la serie
        this.numero = 1; // Método para generar el número
        this.created_at = LocalDateTime.now();
        this.flag_estado = 1;
    }

    private String generateSerie() {
        return "A"; 
    }
}
