package com.fiap.tc.restaurantes.application.ports.out.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;

public interface DeletarRestauranteOutputPort {
  boolean deletarRestaurante(Long id);
}
