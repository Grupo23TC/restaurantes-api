package com.fiap.tc.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.exception.usuario.UsuarioNotFoundException;
import com.fiap.tc.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;

public class DeletarUsuarioUseCase {
  private final DeletarUsuarioInterface deletarUsuarioInterface;
  private final BuscarUsuarioPorIdUseCase buscarUsuarioPorId;

  public DeletarUsuarioUseCase(
      DeletarUsuarioInterface deletarUsuarioInterface,
      BuscarUsuarioPorIdUseCase buscarUsuarioPorId
  ) {
    this.deletarUsuarioInterface = deletarUsuarioInterface;
    this.buscarUsuarioPorId = buscarUsuarioPorId;
  }

  public boolean deletarUsuario(Long id) {
    Usuario usuarioBuscado = buscarUsuarioPorId.buscarUsuarioPorId(id);

    if(usuarioBuscado == null) {
      throw new UsuarioNotFoundException("Id do usuário não encontrado");
    }

    return deletarUsuarioInterface.deletarUsuario(id);
  }
}
