package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper;

import com.sistemacitas.sistemacitas.domain.model.Doctor;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.DoctorEntity;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorPersistenceMapper {
    DoctorEntity toDoctorEntity(Doctor doctor);

    Doctor toDoctor(DoctorEntity doctorEntity);

    List<Doctor> toDoctorList(List<DoctorEntity> doctorEntityList);
}
