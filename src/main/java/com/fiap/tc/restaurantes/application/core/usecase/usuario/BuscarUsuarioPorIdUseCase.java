package com.fiap.tc.restaurantes.application.core.usecase.usuario;

import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.application.ports.in.usuario.BuscarUsuarioPorIdInputPort;
import com.fiap.tc.restaurantes.application.ports.out.usuario.BuscarUsuarioPorIdOutputPort;

public class BuscarUsuarioPorIdUseCase implements BuscarUsuarioPorIdInputPort {
  private final BuscarUsuarioPorIdOutputPort buscarUsuarioPorIdOutputPort;

  public BuscarUsuarioPorIdUseCase(BuscarUsuarioPorIdOutputPort buscarUsuarioPorIdOutputPort) {
    this.buscarUsuarioPorIdOutputPort = buscarUsuarioPorIdOutputPort;
  }

  @Override
  public Usuario buscarUsuarioPorId(Long id) {
    return buscarUsuarioPorIdOutputPort.buscarUsuarioPorId(id);
  }
}
