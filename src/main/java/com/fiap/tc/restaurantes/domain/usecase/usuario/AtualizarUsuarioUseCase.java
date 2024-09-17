package com.fiap.tc.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.AtualizarUsuarioInterface;

public class AtualizarUsuarioUseCase {
  private final AtualizarUsuarioInterface atualizarUsuarioInterface;
  private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

  public AtualizarUsuarioUseCase(AtualizarUsuarioInterface atualizarUsuarioInterface, BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase) {
    this.atualizarUsuarioInterface = atualizarUsuarioInterface;
    this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
  }

  public Usuario atualizarUsuario(Long id, Usuario usuario) {
    buscarUsuarioPorIdUseCase.buscarUsuarioPorId(id);
    return atualizarUsuarioInterface.atualizarUsuario(id, usuario);
  }
}
