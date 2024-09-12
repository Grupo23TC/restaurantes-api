package com.fiap.tc.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.exception.usuario.UsuarioNotFoundException;
import com.fiap.tc.restaurantes.domain.gateway.usuario.AtualizarUsuarioInterface;

public class AtualizarUsuarioUseCase {
  private final AtualizarUsuarioInterface atualizarUsuarioInterface;
  private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

  public AtualizarUsuarioUseCase(
      AtualizarUsuarioInterface atualizarUsuarioInterface,
      BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase
  ) {
    this.atualizarUsuarioInterface = atualizarUsuarioInterface;
    this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
  }

  public Usuario atualizarUsuario(Long id, Usuario usuario) {
    Usuario usuarioBuscado = buscarUsuarioPorIdUseCase.buscarUsuarioPorId(id);

    if(usuarioBuscado == null) {
      throw new UsuarioNotFoundException("Id do usuário não encontrado");
    }

    usuarioBuscado.setNome(usuario.getNome());
    usuarioBuscado.setSenha(usuario.getSenha());
    usuarioBuscado.setTelefone(usuario.getTelefone());

    return atualizarUsuarioInterface.atualizarUsuario(id, usuarioBuscado);
  }
}
