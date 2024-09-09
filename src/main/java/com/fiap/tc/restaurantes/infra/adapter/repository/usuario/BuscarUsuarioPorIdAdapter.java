package com.fiap.tc.restaurantes.infra.adapter.repository.usuario;

import com.fiap.tc.restaurantes.infra.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.infra.entity.UsuarioEntity;
import com.fiap.tc.restaurantes.infra.repository.mapper.UsuarioEntityMapper;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.BuscarUsuarioPorIdInterface;
import org.springframework.stereotype.Component;

@Component
public class BuscarUsuarioPorIdAdapter implements BuscarUsuarioPorIdInterface {
  private final UsuarioRepository usuarioRepository;
  private final UsuarioEntityMapper usuarioEntityMapper;

  public BuscarUsuarioPorIdAdapter(UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper) {
    this.usuarioRepository = usuarioRepository;
    this.usuarioEntityMapper = usuarioEntityMapper;
  }

  @Override
  public Usuario buscarUsuarioPorId(Long id) {
    UsuarioEntity usuarioBuscado = usuarioRepository.findById(id).orElse(null);

    return usuarioEntityMapper.toUsuario(usuarioBuscado);
  }
}
