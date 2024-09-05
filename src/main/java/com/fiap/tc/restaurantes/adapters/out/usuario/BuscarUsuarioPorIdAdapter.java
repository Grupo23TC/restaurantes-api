package com.fiap.tc.restaurantes.adapters.out.usuario;

import com.fiap.tc.restaurantes.adapters.out.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.UsuarioEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.application.ports.out.usuario.BuscarUsuarioPorIdOutputPort;
import org.springframework.stereotype.Component;

@Component
public class BuscarUsuarioPorIdAdapter implements BuscarUsuarioPorIdOutputPort {
  private final UsuarioRepository usuarioRepository;
  private final UsuarioEntityMapper usuarioEntityMapper;

  public BuscarUsuarioPorIdAdapter(UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper) {
    this.usuarioRepository = usuarioRepository;
    this.usuarioEntityMapper = usuarioEntityMapper;
  }

  @Override
  public Usuario buscarUsuarioPorId(Long id) {
    UsuarioEntity usuarioBuscado = usuarioRepository.
        findById(id)
        .orElseThrow(
            () -> new IllegalArgumentException("Id do usuário não encontrado")
        );

    return usuarioEntityMapper.toUsuario(usuarioBuscado);
  }
}
