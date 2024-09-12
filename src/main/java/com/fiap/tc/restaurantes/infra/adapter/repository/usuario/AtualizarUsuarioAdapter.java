package com.fiap.tc.restaurantes.infra.adapter.repository.usuario;

import com.fiap.tc.restaurantes.infra.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.infra.entity.UsuarioEntity;
import com.fiap.tc.restaurantes.infra.repository.mapper.UsuarioEntityMapper;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.AtualizarUsuarioInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtualizarUsuarioAdapter implements AtualizarUsuarioInterface {
  private final UsuarioRepository usuarioRepository;
  private final UsuarioEntityMapper usuarioEntityMapper;
  private final BuscarUsuarioPorIdAdapter buscarUsuarioPorIdAdapter;

  @Override
  public Usuario atualizarUsuario(Long id, Usuario usuario) {
    Usuario usuarioBuscado = buscarUsuarioPorIdAdapter.buscarUsuarioPorId(id);

    usuarioBuscado.setNome(usuario.getNome());
    usuarioBuscado.setEmail(usuario.getEmail());
    usuarioBuscado.setTelefone(usuario.getTelefone());

    UsuarioEntity usuarioAtualizado = usuarioRepository.save(usuarioEntityMapper.toUsuarioEntity(usuarioBuscado));

    return usuarioEntityMapper.toUsuario(usuarioAtualizado);
  }
}
