package com.fiap.tc.restaurantes.domain.usecase.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorTipoCozinhaInterface;

import java.util.List;

public class BuscarRestaurantePorTipoCozinhaUseCase {
  private final BuscarRestaurantePorTipoCozinhaInterface buscarRestaurantePorTipoCozinhaInterface;

  public BuscarRestaurantePorTipoCozinhaUseCase(BuscarRestaurantePorTipoCozinhaInterface buscarRestaurantePorTipoCozinhaInterface) {
    this.buscarRestaurantePorTipoCozinhaInterface = buscarRestaurantePorTipoCozinhaInterface;
  }

  public List<Restaurante> buscarPorTipoCozinha(String tipoCozinha) {
    return buscarRestaurantePorTipoCozinhaInterface.buscarPorTipoCozinha(tipoCozinha);
  }
}
