package com.fiap.tc.restaurantes.infra.adapter.repository.usuario;

import com.fiap.tc.restaurantes.infra.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.UsuarioEntityMapper;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.ListarUsuariosInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarUsuariosAdapter implements ListarUsuariosInterface {
  private final UsuarioRepository usuarioRepository;
  private final UsuarioEntityMapper usuarioEntityMapper;

  @Override
  public List<Usuario> listarUsuarios() {
    return usuarioRepository.findAll().stream().map(usuarioEntityMapper::toUsuario).toList();
  }
}
