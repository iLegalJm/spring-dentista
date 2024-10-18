package com.sistemacitas.sistemacitas.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.sistemacitas.sistemacitas.domain.model.Doctor;

public interface DoctorPersistencePort {
    Optional<Doctor> getDoctor(Long id);

    List<Doctor> getDoctors();

    Doctor createDoctor(Doctor doctor);

    void deleteDoctor(Long id);
}
