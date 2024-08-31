package com.fiap.tc.restaurantes.application.ports.out.usuario;

import com.fiap.tc.restaurantes.application.core.domain.Usuario;

import java.util.List;

public interface ListarUsuariosOutputPort {
  List<Usuario> listarUsuarios();
}
