package com.fiap.tc.restaurantes.application.ports.out.usuario;

import com.fiap.tc.restaurantes.application.core.domain.Usuario;

public interface BuscarUsuarioPorIdOutputPort {
  Usuario buscarUsuarioPorId(Long id);
}
