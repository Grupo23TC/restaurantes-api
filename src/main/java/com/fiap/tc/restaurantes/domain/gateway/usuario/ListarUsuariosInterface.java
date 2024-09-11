package com.fiap.tc.restaurantes.domain.gateway.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;

import java.util.List;

public interface ListarUsuariosInterface {
  List<Usuario> listarUsuarios();
}
