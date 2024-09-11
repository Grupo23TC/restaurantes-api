package com.fiap.tc.restaurantes.domain.gateway.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;

public interface BuscarUsuarioPorIdInterface {
  Usuario buscarUsuarioPorId(Long id);
}
