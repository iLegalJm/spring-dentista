package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.sistemacitas.sistemacitas.domain.model.Dentista;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.DentistaEntity;

@Mapper(componentModel = "spring")
public interface DentistaPersistenceMapper {
    DentistaEntity toDentistaEntity(Dentista dentista);

    Dentista toDentista(DentistaEntity dentistaEntity);

    List<Dentista> toDentistaList(List<DentistaEntity> dentistaEntityList);
}
