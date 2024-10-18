package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper;

import com.sistemacitas.sistemacitas.domain.model.Doctor;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.DoctorCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.DoctorResponse;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface DoctorRestMapper {
    Doctor toDoctor(DoctorCreateRequest request);

    DoctorResponse toDoctorResponse(Doctor doctor);

    List<DoctorResponse> toDoctorResponseList(List<Doctor> doctorList);
}
