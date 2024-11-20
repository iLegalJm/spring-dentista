package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper;

import com.sistemacitas.sistemacitas.domain.model.Doctor;
import com.sistemacitas.sistemacitas.domain.model.Especialidad;
import com.sistemacitas.sistemacitas.domain.model.Persona;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.DoctorCreateRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.DoctorResponse;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface DoctorRestMapper {

    @Mapping(target = "persona.nombre", source = "nombre")
    @Mapping(target = "persona.apellidos", source = "apellidos")
    @Mapping(target = "persona.dni", source = "dni")
    @Mapping(target = "persona.telefono", source = "telefono")
    @Mapping(target = "persona.email", source = "email")
    @Mapping(target = "persona.direccion", source = "direccion")
    @Mapping(target = "especialidad", source = "especialidad", qualifiedByName = "mapEspecialidad")
    Doctor toDoctor(DoctorCreateRequest request);

    @Mapping(source = "persona", target = "persona")
    @Mapping(source = "especialidad", target = "especialidad")
    DoctorResponse toDoctorResponse(Doctor doctor);

    List<DoctorResponse> toDoctorResponseList(List<Doctor> doctorList);

    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellidos", source = "apellidos")
    @Mapping(target = "dni", source = "dni")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "direccion", source = "direccion")
    Persona toPersona(DoctorCreateRequest request);

    @Named("mapEspecialidad")
    default Especialidad mapEspecialidad(Long especialidadId) {
        if (especialidadId == null) {
            return null;
        }
        Especialidad especialidad = new Especialidad();
        especialidad.setId(especialidadId);
        return especialidad;
    }
}
