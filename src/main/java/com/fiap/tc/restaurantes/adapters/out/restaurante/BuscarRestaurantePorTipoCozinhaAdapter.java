package com.fiap.tc.restaurantes.adapters.out.restaurante;


import com.fiap.tc.restaurantes.adapters.out.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.core.domain.enumeration.TipoCozinhaEnum;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.BuscarRestaurantePorTipoCozinhaOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarRestaurantePorTipoCozinhaAdapter implements BuscarRestaurantePorTipoCozinhaOutputPort {
  private final RestauranteRepository restauranteRepository;
  private final RestauranteEntityMapper restauranteMapper;

  @Override
  public List<Restaurante> buscarPorTipoCozinha(String tipoCozinha) {
    return restauranteRepository.findByTipoDeCozinha(tipoCozinha).stream().map(restauranteMapper::toRestaurante).toList();
  }
}
