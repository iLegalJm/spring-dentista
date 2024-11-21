package com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sistemacitas.sistemacitas.domain.model.Usuario;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioPersistenceMapper {
    UsuarioEntity toUsuarioEntity(Usuario usuario);

    Usuario toUsuario(UsuarioEntity usuarioEntity);

    List<Usuario> toUsuarioList(List<UsuarioEntity> usuarioEntityList);
}
