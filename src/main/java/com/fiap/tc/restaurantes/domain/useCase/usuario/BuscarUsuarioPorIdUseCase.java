package com.fiap.tc.restaurantes.domain.useCase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.BuscarUsuarioPorIdInterface;

public class BuscarUsuarioPorIdUseCase {
  private final BuscarUsuarioPorIdInterface buscarUsuarioPorIdInterface;

  public BuscarUsuarioPorIdUseCase(BuscarUsuarioPorIdInterface buscarUsuarioPorIdInterface) {
    this.buscarUsuarioPorIdInterface = buscarUsuarioPorIdInterface;
  }

  public Usuario buscarUsuarioPorId(Long id) {
    Usuario usuario = buscarUsuarioPorIdInterface.buscarUsuarioPorId(id);
    if(usuario == null) {
      throw new IllegalArgumentException("Id do usuário não encontrado");
    }
    return buscarUsuarioPorIdInterface.buscarUsuarioPorId(id);
  }
}
