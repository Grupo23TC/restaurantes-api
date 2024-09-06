package com.fiap.tc.restaurantes.application.ports.out.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;

import java.util.List;

public interface BuscarRestaurantePorLocalidadeOutputPort {
  List<Restaurante> buscarRestaurantePorLocalidade(String localidade);
}
