package com.fiap.tc.restaurantes.application.core.usecase.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.in.restaurante.BuscarRestaurantePorLocalidadeInputPort;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.BuscarRestaurantePorLocalidadeOutputPort;

import java.util.List;

public class BuscarRestaurantePorLocalidadeUseCase implements BuscarRestaurantePorLocalidadeInputPort {
  private final BuscarRestaurantePorLocalidadeOutputPort buscarRestaurantePorLocalidadeOutputPort;

  public BuscarRestaurantePorLocalidadeUseCase(BuscarRestaurantePorLocalidadeOutputPort buscarRestaurantePorLocalidadeOutputPort) {
    this.buscarRestaurantePorLocalidadeOutputPort = buscarRestaurantePorLocalidadeOutputPort;
  }

  @Override
  public List<Restaurante> buscarRestaurantePorLocalidade(String localidade) {
    return buscarRestaurantePorLocalidadeOutputPort.buscarRestaurantePorLocalidade(localidade);
  }
}
