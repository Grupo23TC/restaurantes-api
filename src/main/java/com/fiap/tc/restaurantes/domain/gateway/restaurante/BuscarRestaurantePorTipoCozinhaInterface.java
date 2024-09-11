package com.fiap.tc.restaurantes.domain.gateway.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;

import java.util.List;

public interface BuscarRestaurantePorTipoCozinhaInterface {
  List<Restaurante> buscarPorTipoCozinha(String tipoCozinha);
}
