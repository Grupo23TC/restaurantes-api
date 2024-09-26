package com.fiap.tc.restaurantes.domain.mapper.usuario;

import com.fiap.tc.restaurantes.domain.input.usuario.AtualizarUsuarioRequest;
import com.fiap.tc.restaurantes.domain.input.usuario.CadastrarUsuarioRequest;
import com.fiap.tc.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {


  /**
   * @param cadastrarUsuarioRequest
   * @return
   */
  @Mapping(target = "usuarioId", ignore = true)
  Usuario toUsuario(CadastrarUsuarioRequest cadastrarUsuarioRequest);

  /**
   * @param atualizarUsuarioRequest
   * @return
   */
  @Mapping(target = "usuarioId", ignore = true)
  Usuario toUsuario(AtualizarUsuarioRequest atualizarUsuarioRequest);

  /**
   * @param usuario
   * @return
   */
  UsuarioResponse toUsuarioResponse(Usuario usuario);
}
