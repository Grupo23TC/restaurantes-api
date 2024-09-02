package com.fiap.tc.restaurantes.application.ports.out.restaurante;

import com.fiap.tc.restaurantes.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;

public interface AtualizarRestauranteOutputPort {
  Restaurante atualizarRestaurante(Long restauranteId, Restaurante restaurante);

  RestauranteEntity buscarRestaurantePorId(Long restauranteId);

}
