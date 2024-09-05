package com.fiap.tc.restaurantes.application.ports.in.usuario;

import com.fiap.tc.restaurantes.application.core.domain.Usuario;

import java.util.List;

public interface ListarUsuariosInputPort {
  List<Usuario> listarUsuarios();
}
