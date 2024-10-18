package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import com.sistemacitas.sistemacitas.application.ports.output.DoctorPersistencePort;
import com.sistemacitas.sistemacitas.domain.model.Doctor;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper.DoctorPersistenceMapper;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DoctorPersistenceAdapter implements DoctorPersistencePort {

    private final DoctorRepository doctorRepository;

    private final DoctorPersistenceMapper persistenceMapper;

    @Override
    public Optional<Doctor> getDoctor(Long id) {
        return doctorRepository.findById(id).map(persistenceMapper::toDoctor);
    }

    @Override
    public List<Doctor> getDoctors() {
        return persistenceMapper.toDoctorList(doctorRepository.findAll());
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return persistenceMapper.toDoctor(doctorRepository.save(persistenceMapper.toDoctorEntity(doctor)));
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

}
