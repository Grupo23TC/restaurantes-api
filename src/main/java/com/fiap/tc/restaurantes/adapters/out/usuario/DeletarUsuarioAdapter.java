package com.fiap.tc.restaurantes.adapters.out.usuario;

import com.fiap.tc.restaurantes.adapters.out.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.application.ports.out.usuario.BuscarUsuarioPorIdOutputPort;
import com.fiap.tc.restaurantes.application.ports.out.usuario.DeletarUsuarioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarUsuarioAdapter implements DeletarUsuarioOutputPort {
  private final UsuarioRepository usuarioRepository;
  private final BuscarUsuarioPorIdOutputPort buscarUsuarioPorIdOutputPort;

  @Override
  public boolean deletarUsuario(Long id) {
    buscarUsuarioPorIdOutputPort.buscarUsuarioPorId(id);
    return true;
  }
}
