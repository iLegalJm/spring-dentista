package com.sistemacitas.sistemacitas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemacitas.sistemacitas.application.ports.input.DoctorServicePort;
import com.sistemacitas.sistemacitas.application.ports.output.DoctorPersistencePort;
import com.sistemacitas.sistemacitas.application.ports.output.PersonaPersistencePort;
import com.sistemacitas.sistemacitas.domain.exception.DotorNotFoundException;
import com.sistemacitas.sistemacitas.domain.model.Doctor;
import com.sistemacitas.sistemacitas.domain.model.Persona;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService implements DoctorServicePort {

    private final DoctorPersistencePort persistencePort;
    private final PersonaPersistencePort personaPersistencePort;

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
        Persona persona = new Persona();
        persona.setNombre(doctor.getPersona().getNombre());
        persona.setApellidos(doctor.getPersona().getApellidos());
        persona.setDni(doctor.getPersona().getDni());
        persona.setTelefono(doctor.getPersona().getTelefono());
        persona.setEmail(doctor.getPersona().getEmail());
        persona.setDireccion(doctor.getPersona().getDireccion());
        persona = personaPersistencePort.createPersona(persona);

        doctor.setPersona(persona);
        doctor.setEspecialidad(doctor.getEspecialidad());
        return persistencePort.createDoctor(doctor);
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        // return persistencePort.getDoctor(id).map(saveDoctor -> {
        // saveDoctor.setId(saveDoctor.getId());
        // saveDoctor.setNombre(doctor.getNombre());
        // saveDoctor.setApellidos(doctor.getApellidos());
        // saveDoctor.setDni(doctor.getDni());
        // saveDoctor.setTelefono(doctor.getTelefono());
        // saveDoctor.setEmail(doctor.getEmail());
        // saveDoctor.setDireccion(doctor.getDireccion());
        // return persistencePort.createDoctor(saveDoctor);
        // }).orElseThrow(() -> new DotorNotFoundException("Doctor no encontrado"));
        return null;
    }

    @Override
    public void deleteDoctor(Long id) {
        if (persistencePort.getDoctor(id).isEmpty()) {
            throw new DotorNotFoundException("Doctor no encontrado");
        }
        persistencePort.deleteDoctor(id);
    }

}
