package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper;

import com.sistemacitas.sistemacitas.domain.model.Cita;
import com.sistemacitas.sistemacitas.domain.model.Doctor;
import com.sistemacitas.sistemacitas.domain.model.Paciente;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.CitaCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.CitaResponse;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CitaRestMapper {

    @Mapping(source = "paciente", target = "paciente", qualifiedByName = "mapToPaciente")
    @Mapping(source = "doctor", target = "doctor", qualifiedByName = "mapToDoctor")
    Cita toCita(CitaCreateRequest request);

    CitaResponse toCitaResponse(Cita cita);

    List<CitaResponse> toCitaResponseList(List<Cita> citaList);

    @Named("mapToPaciente")
    default Paciente mapToPaciente(Long value) {
        if (value == null) {
            return null;
        }
        Paciente paciente = new Paciente();
        paciente.setId(value);
        return paciente;
    }

    @Named("mapToDoctor")
    default Doctor mapToDoctor(Long value) {
        if (value == null) {
            return null;
        }
        Doctor doctor = new Doctor();
        doctor.setId(value);
        return doctor;
    }
}
