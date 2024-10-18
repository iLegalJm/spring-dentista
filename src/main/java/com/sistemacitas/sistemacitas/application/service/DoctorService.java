package com.sistemacitas.sistemacitas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemacitas.sistemacitas.application.ports.input.DoctorServicePort;
import com.sistemacitas.sistemacitas.application.ports.output.DoctorPersistencePort;
import com.sistemacitas.sistemacitas.domain.exception.DotorNotFoundException;
import com.sistemacitas.sistemacitas.domain.model.Doctor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService implements DoctorServicePort {

    private final DoctorPersistencePort persistencePort;

    @Override
    public Doctor getDoctor(Long id) {
        return persistencePort.getDoctor(id)
                .orElseThrow(() -> new DotorNotFoundException("Doctor no encontrado"));
    }

    @Override
    public List<Doctor> getDoctors() {
        return persistencePort.getDoctors();
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return persistencePort.createDoctor(doctor);
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        return persistencePort.getDoctor(id).map(saveDoctor -> {
            saveDoctor.setId(saveDoctor.getId());
            saveDoctor.setNombre(doctor.getNombre());
            saveDoctor.setApellidos(doctor.getApellidos());
            saveDoctor.setDni(doctor.getDni());
            saveDoctor.setTelefono(doctor.getTelefono());
            saveDoctor.setEmail(doctor.getEmail());
            saveDoctor.setDireccion(doctor.getDireccion());
            return persistencePort.createDoctor(saveDoctor);
        }).orElseThrow(() -> new DotorNotFoundException("Doctor no encontrado"));
    }

    @Override
    public void deleteDoctor(Long id) {
        if (persistencePort.getDoctor(id).isEmpty()) {
            throw new DotorNotFoundException("Doctor no encontrado");
        }
        persistencePort.deleteDoctor(id);
    }

}
