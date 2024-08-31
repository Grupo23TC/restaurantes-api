package com.fiap.tc.restaurantes.application.core.usecase.usuario;

import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.application.ports.in.usuario.ListarUsuariosInputPort;
import com.fiap.tc.restaurantes.application.ports.out.usuario.ListarUsuariosOutputPort;

import java.util.List;

public class ListarUsuariosUseCase implements ListarUsuariosInputPort {
  private final ListarUsuariosOutputPort listarUsuariosOutputPort;

  public ListarUsuariosUseCase(ListarUsuariosOutputPort listarUsuariosOutputPort) {
    this.listarUsuariosOutputPort = listarUsuariosOutputPort;
  }

  @Override
  public List<Usuario> listarUsuarios() {
    return listarUsuariosOutputPort.listarUsuarios();
  }
}
