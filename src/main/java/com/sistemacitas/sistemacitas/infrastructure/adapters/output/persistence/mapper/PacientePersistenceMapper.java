package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;

import com.sistemacitas.sistemacitas.domain.model.Paciente;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.PacienteEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PacientePersistenceMapper {
    PacienteEntity toPacienteEntity(Paciente pacienteEntity);

    Paciente toPaciente(PacienteEntity pacienteEntity);

    List<Paciente> toPacienteList(List<PacienteEntity> pacienteEntityList);
}
