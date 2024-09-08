package com.fiap.tc.restaurantes.domain.mapper.usuario;


import com.fiap.tc.restaurantes.domain.input.usuario.AtualizarUsuarioRequest;
import com.fiap.tc.restaurantes.domain.input.usuario.CadastrarUsuarioRequest;
import com.fiap.tc.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
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
