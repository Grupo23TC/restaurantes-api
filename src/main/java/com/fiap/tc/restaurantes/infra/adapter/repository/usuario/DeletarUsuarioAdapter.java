package com.fiap.tc.restaurantes.infra.adapter.repository.usuario;

import com.fiap.tc.restaurantes.infra.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.domain.gateway.usuario.BuscarUsuarioPorIdInterface;
import com.fiap.tc.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarUsuarioAdapter implements DeletarUsuarioInterface {
  private final UsuarioRepository usuarioRepository;
  private final BuscarUsuarioPorIdInterface buscarUsuarioPorIdInterface;

  @Override
  public boolean deletarUsuario(Long id) {
    buscarUsuarioPorIdInterface.buscarUsuarioPorId(id);
    return true;
  }
}
