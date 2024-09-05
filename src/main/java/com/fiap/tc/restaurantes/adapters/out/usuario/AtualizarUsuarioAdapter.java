package com.fiap.tc.restaurantes.adapters.out.usuario;

import com.fiap.tc.restaurantes.adapters.out.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.UsuarioEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.application.ports.out.usuario.AtualizarUsuarioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtualizarUsuarioAdapter implements AtualizarUsuarioOutputPort {
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
