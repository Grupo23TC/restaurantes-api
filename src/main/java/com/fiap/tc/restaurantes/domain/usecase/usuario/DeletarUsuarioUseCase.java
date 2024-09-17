package com.fiap.tc.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;

public class DeletarUsuarioUseCase {
  private final DeletarUsuarioInterface deletarUsuarioInterface;
  private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

  public DeletarUsuarioUseCase(DeletarUsuarioInterface deletarUsuarioInterface, BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase) {
    this.deletarUsuarioInterface = deletarUsuarioInterface;
    this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
  }

  public boolean deletarUsuario(Long id) {
    buscarUsuarioPorIdUseCase.buscarUsuarioPorId(id);
    return deletarUsuarioInterface.deletarUsuario(id);
  }
}
