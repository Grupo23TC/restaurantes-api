package com.fiap.tc.restaurantes.application.core.usecase.usuario;

import com.fiap.tc.restaurantes.application.ports.in.usuario.DeletarUsuarioInputPort;
import com.fiap.tc.restaurantes.application.ports.out.usuario.DeletarUsuarioOutputPort;

public class DeletarUsuarioUseCase implements DeletarUsuarioInputPort {
  private final DeletarUsuarioOutputPort deletarUsuarioOutputPort;

  public DeletarUsuarioUseCase(DeletarUsuarioOutputPort deletarUsuarioOutputPort) {
    this.deletarUsuarioOutputPort = deletarUsuarioOutputPort;
  }

  @Override
  public boolean deletarUsuario(Long id) {
    return deletarUsuarioOutputPort.deletarUsuario(id);
  }
}
