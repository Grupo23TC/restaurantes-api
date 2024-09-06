package com.fiap.tc.restaurantes.adapters.out.restaurante;

import com.fiap.tc.restaurantes.adapters.out.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.BuscarRestaurantePorLocalidadeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarRestaurantePorLocalidadeAdapter implements BuscarRestaurantePorLocalidadeOutputPort {
  private final RestauranteRepository restauranteRepository;
  private final RestauranteEntityMapper restauranteMapper;
  @Override
  public List<Restaurante> buscarRestaurantePorLocalidade(String localidade) {
    return restauranteRepository.findByLocalidade(localidade).stream().map(restauranteMapper::toRestaurante).toList();
  }
}
