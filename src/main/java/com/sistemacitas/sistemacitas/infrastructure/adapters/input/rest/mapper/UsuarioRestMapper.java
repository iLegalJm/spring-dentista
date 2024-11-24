package com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.sistemacitas.sistemacitas.domain.model.Persona;
import com.sistemacitas.sistemacitas.domain.model.Usuario;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.request.UsuarioRequest;
import com.sistemacitas.sistemacitas.infrastructure.adapters.input.rest.model.response.UsuarioResponse;

@Mapper(componentModel = "spring")
public interface UsuarioRestMapper {

    @Mapping(source = "persona", target = "persona", qualifiedByName = "mapPersona")
    Usuario toUsuario(UsuarioRequest usuarioRequest);

    UsuarioResponse toUsuarioResponse(Usuario usuario);

    List<UsuarioResponse> toUsuarioResponseList(List<Usuario> usuarioList);

    @Named("mapPersona")
    default Persona mapPersona(Long personaId) {
        if (personaId == null) {
            return null;
        }
        Persona persona = new Persona();
        persona.setId(personaId);
        return persona;
    }
}
