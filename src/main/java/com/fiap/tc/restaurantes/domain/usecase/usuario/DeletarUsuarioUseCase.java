package com.fiap.tc.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;

public class DeletarUsuarioUseCase {
  private final DeletarUsuarioInterface deletarUsuarioInterface;

  public DeletarUsuarioUseCase(DeletarUsuarioInterface deletarUsuarioInterface) {
    this.deletarUsuarioInterface = deletarUsuarioInterface;
  }

  public boolean deletarUsuario(Long id) {
    return deletarUsuarioInterface.deletarUsuario(id);
  }
}
