package com.fiap.tc.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.CadastrarUsuarioInterface;

public class CadastrarUsuarioUseCase {
  private final CadastrarUsuarioInterface cadastrarUsuarioInterface;

  public CadastrarUsuarioUseCase(CadastrarUsuarioInterface cadastrarUsuarioInterface) {
    this.cadastrarUsuarioInterface = cadastrarUsuarioInterface;
  }

  public Usuario cadastrarUsuario(Usuario usuario) {
    return cadastrarUsuarioInterface.cadastrarUsuario(usuario);
  }
}
