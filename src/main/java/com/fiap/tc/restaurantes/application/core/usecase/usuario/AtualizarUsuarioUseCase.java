package com.fiap.tc.restaurantes.application.core.usecase.usuario;

import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.application.ports.in.usuario.AtualizarUsuarioInputPort;
import com.fiap.tc.restaurantes.application.ports.out.usuario.AtualizarUsuarioOutputPort;

public class AtualizarUsuarioUseCase implements AtualizarUsuarioInputPort {
  private final AtualizarUsuarioOutputPort atualizarUsuarioOutputPort;

  public AtualizarUsuarioUseCase(AtualizarUsuarioOutputPort atualizarUsuarioOutputPort) {
    this.atualizarUsuarioOutputPort = atualizarUsuarioOutputPort;
  }

  @Override
  public Usuario atualizarUsuario(Long id, Usuario usuario) {
    return atualizarUsuarioOutputPort.atualizarUsuario(id, usuario);
  }
}
