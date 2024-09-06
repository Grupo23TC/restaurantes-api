package com.fiap.tc.restaurantes.infra.adapter.repository.restaurante;


import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorTipoCozinhaInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarRestaurantePorTipoCozinhaAdapter implements BuscarRestaurantePorTipoCozinhaInterface {
  private final RestauranteRepository restauranteRepository;
  private final RestauranteEntityMapper restauranteMapper;

  @Override
  public List<Restaurante> buscarPorTipoCozinha(String tipoCozinha) {
    return restauranteRepository.findByTipoDeCozinha(tipoCozinha).stream().map(restauranteMapper::toRestaurante).toList();
  }
}
