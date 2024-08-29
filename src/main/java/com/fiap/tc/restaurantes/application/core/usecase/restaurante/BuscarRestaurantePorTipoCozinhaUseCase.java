package com.fiap.tc.restaurantes.application.core.usecase.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.core.domain.enumeration.TipoCozinhaEnum;
import com.fiap.tc.restaurantes.application.ports.in.restaurante.BuscarRestaurantePorTipoCozinhaInputPort;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.BuscarRestaurantePorTipoCozinhaOutputPort;

import java.util.List;

public class BuscarRestaurantePorTipoCozinhaUseCase implements BuscarRestaurantePorTipoCozinhaInputPort {
  private final BuscarRestaurantePorTipoCozinhaOutputPort buscarRestaurantePorTipoCozinhaOutputPort;

  public BuscarRestaurantePorTipoCozinhaUseCase(BuscarRestaurantePorTipoCozinhaOutputPort buscarRestaurantePorTipoCozinhaOutputPort) {
    this.buscarRestaurantePorTipoCozinhaOutputPort = buscarRestaurantePorTipoCozinhaOutputPort;
  }

  @Override
  public List<Restaurante> buscarPorTipoCozinha(String tipoCozinha) {
    return buscarRestaurantePorTipoCozinhaOutputPort.buscarPorTipoCozinha(tipoCozinha);
  }
}
