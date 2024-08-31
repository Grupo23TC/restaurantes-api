package com.fiap.tc.restaurantes.adapters.out.usuario;

import com.fiap.tc.restaurantes.adapters.out.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.UsuarioEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.application.ports.out.usuario.CadastrarUsuarioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarUsuarioAdapter implements CadastrarUsuarioOutputPort {
  private final UsuarioRepository usuarioRepository;
  private final UsuarioEntityMapper usuarioEntityMapper;


  @Override
  public Usuario cadastrarUsuario(Usuario usuario) {
    UsuarioEntity usuarioEntity = usuarioEntityMapper.toUsuarioEntity(usuario);
    usuarioRepository.save(usuarioEntity);
    return usuarioEntityMapper.toUsuario(usuarioEntity);
  }
}
