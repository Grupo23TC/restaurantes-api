package com.fiap.tc.restaurantes.infra.adapter.repository.usuario;

import com.fiap.tc.restaurantes.infra.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.infra.entity.UsuarioEntity;
import com.fiap.tc.restaurantes.infra.repository.mapper.UsuarioEntityMapper;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.CadastrarUsuarioInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarUsuarioAdapter implements CadastrarUsuarioInterface {
  private final UsuarioRepository usuarioRepository;
  private final UsuarioEntityMapper usuarioEntityMapper;


  @Override
  public Usuario cadastrarUsuario(Usuario usuario) {
    UsuarioEntity usuarioEntity = usuarioEntityMapper.toUsuarioEntity(usuario);
    usuarioRepository.save(usuarioEntity);
    return usuarioEntityMapper.toUsuario(usuarioEntity);
  }
}
