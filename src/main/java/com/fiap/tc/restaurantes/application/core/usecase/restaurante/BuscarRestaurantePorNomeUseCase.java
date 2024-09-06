package com.fiap.tc.restaurantes.application.core.usecase.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.in.restaurante.BuscarRestaurantePorNomeInputPort;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.BuscarRestaurantePorNomeOutputPort;

import java.util.List;

public class BuscarRestaurantePorNomeUseCase implements BuscarRestaurantePorNomeInputPort {
  private final BuscarRestaurantePorNomeOutputPort buscarRestaurantePorNomeOutputPort;

  public BuscarRestaurantePorNomeUseCase(BuscarRestaurantePorNomeOutputPort buscarRestaurantePorNomeOutputPort) {
    this.buscarRestaurantePorNomeOutputPort = buscarRestaurantePorNomeOutputPort;
  }

  @Override
  public List<Restaurante> buscarRestaurantePorNome(String nome) {
    return buscarRestaurantePorNomeOutputPort.buscarRestaurantePorNome(nome);
  }
}
