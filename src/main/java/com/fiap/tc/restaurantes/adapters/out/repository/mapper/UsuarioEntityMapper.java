package com.fiap.tc.restaurantes.adapters.out.repository.mapper;

import com.fiap.tc.restaurantes.adapters.out.repository.entity.UsuarioEntity;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {
  UsuarioEntityMapper INSTANCE = Mappers.getMapper(UsuarioEntityMapper.class);

  /**
   * @param usuario
   * @return
   */
  UsuarioEntity toUsuarioEntity(Usuario usuario);

  /**
   * @param usuarioEntity
   * @return
   */
  Usuario toUsuario(UsuarioEntity usuarioEntity);
}
