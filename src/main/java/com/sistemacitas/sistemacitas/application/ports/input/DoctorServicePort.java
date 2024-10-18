package com.sistemacitas.sistemacitas.application.ports.input;

import com.sistemacitas.sistemacitas.domain.model.Doctor;

import java.util.List;

public interface DoctorServicePort {
    public Doctor getDoctor(Long id);

    public List<Doctor> getDoctors();

    public Doctor createDoctor(Doctor doctor);

    public Doctor updateDoctor(Long id, Doctor doctor);

    public void deleteDoctor(Long id);
}
