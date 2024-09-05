package com.fiap.tc.restaurantes.application.ports.in.usuario;

import com.fiap.tc.restaurantes.application.core.domain.Usuario;

public interface AtualizarUsuarioInputPort {
  Usuario atualizarUsuario(Long id, Usuario usuario);
}
