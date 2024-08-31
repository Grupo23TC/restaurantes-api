package com.fiap.tc.restaurantes.adapters.in.controller.usuario.mapper;


import com.fiap.tc.restaurantes.adapters.in.controller.usuario.request.CadastrarUsuarioRequest;
import com.fiap.tc.restaurantes.adapters.in.controller.usuario.response.UsuarioResponse;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
  UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

  /**
   * @param cadastrarUsuarioRequest
   * @return
   */
  @Mapping(target = "usuarioId", ignore = true)
  Usuario toUsuario(CadastrarUsuarioRequest cadastrarUsuarioRequest);

  /**
   * @param usuario
   * @return
   */
  UsuarioResponse toUsuarioResponse(Usuario usuario);
}
