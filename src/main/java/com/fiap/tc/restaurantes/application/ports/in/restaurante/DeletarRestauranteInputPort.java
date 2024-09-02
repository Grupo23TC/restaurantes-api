package com.fiap.tc.restaurantes.application.ports.in.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;

public interface DeletarRestauranteInputPort {
  boolean deletarRestaurante(Long id);
}
