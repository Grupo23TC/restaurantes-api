package com.fiap.tc.restaurantes.application.ports.out.usuario;

import com.fiap.tc.restaurantes.application.core.domain.Usuario;

public interface CadastrarUsuarioOutputPort {
  Usuario cadastrarUsuario(Usuario usuario);
}
