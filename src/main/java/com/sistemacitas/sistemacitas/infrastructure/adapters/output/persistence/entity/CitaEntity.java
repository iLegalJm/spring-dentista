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
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    private String serie;
    private int numero;
    private LocalDateTime fecha;
    private String motivo;
    private LocalDateTime createdAt;
    private int flagEstado;

    @PrePersist
    protected void onCreate() {
        this.serie = generateSerie(); // Método para generar la serie
        this.numero = 1; // Método para generar el número
        this.createdAt = LocalDateTime.now();
        this.flagEstado = 1;
    }

    private String generateSerie() {
        return "A"; 
    }
}
