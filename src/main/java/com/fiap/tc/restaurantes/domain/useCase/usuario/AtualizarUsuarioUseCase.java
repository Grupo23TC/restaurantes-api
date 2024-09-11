package com.fiap.tc.restaurantes.domain.useCase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.AtualizarUsuarioInterface;

public class AtualizarUsuarioUseCase {
  private final AtualizarUsuarioInterface atualizarUsuarioInterface;

  public AtualizarUsuarioUseCase(AtualizarUsuarioInterface atualizarUsuarioInterface) {
    this.atualizarUsuarioInterface = atualizarUsuarioInterface;
  }

  public Usuario atualizarUsuario(Long id, Usuario usuario) {
    return atualizarUsuarioInterface.atualizarUsuario(id, usuario);
  }
}
