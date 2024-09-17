package com.fiap.tc.restaurantes.domain.usecase.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorLocalidadeInterface;

import java.util.List;

public class BuscarRestaurantePorLocalidadeUseCase {
  private final BuscarRestaurantePorLocalidadeInterface buscarRestaurantePorLocalidadeInterface;

  public BuscarRestaurantePorLocalidadeUseCase(BuscarRestaurantePorLocalidadeInterface buscarRestaurantePorLocalidadeInterface) {
    this.buscarRestaurantePorLocalidadeInterface = buscarRestaurantePorLocalidadeInterface;
  }

  public List<Restaurante> buscarRestaurantePorLocalidade(String localidade) {
    return buscarRestaurantePorLocalidadeInterface.buscarRestaurantePorLocalidade(localidade);
  }
}
