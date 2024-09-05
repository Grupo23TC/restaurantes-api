package com.fiap.tc.restaurantes.application.core.usecase.usuario;

import com.fiap.tc.restaurantes.adapters.in.controller.usuario.request.CadastrarUsuarioRequest;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.application.ports.in.usuario.CadastrarUsuarioInputPort;
import com.fiap.tc.restaurantes.application.ports.out.usuario.CadastrarUsuarioOutputPort;

public class CadastrarUsuarioUseCase implements CadastrarUsuarioInputPort {
  private final CadastrarUsuarioOutputPort cadastrarUsuarioOutputPort;

  public CadastrarUsuarioUseCase(CadastrarUsuarioOutputPort cadastrarUsuarioOutputPort) {
    this.cadastrarUsuarioOutputPort = cadastrarUsuarioOutputPort;
  }

  @Override
  public Usuario cadastrarUsuario(Usuario usuario) {
    return cadastrarUsuarioOutputPort.cadastrarUsuario(usuario);
  }
}
