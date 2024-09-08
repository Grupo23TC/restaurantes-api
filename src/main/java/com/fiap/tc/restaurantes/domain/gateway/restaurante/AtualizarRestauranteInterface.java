package com.fiap.tc.restaurantes.domain.gateway.restaurante;

import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;

public interface AtualizarRestauranteInterface {
  Restaurante atualizarRestaurante(Long restauranteId, Restaurante restaurante);

  RestauranteEntity buscarRestaurantePorId(Long restauranteId);

}
