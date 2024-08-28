package com.fiap.tc.restaurantes.application.ports.in.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;

public interface AtualizarRestauranteInputPort {
  Restaurante atualizarRestaurante(Long restauranteId, Restaurante restaurante);
}
