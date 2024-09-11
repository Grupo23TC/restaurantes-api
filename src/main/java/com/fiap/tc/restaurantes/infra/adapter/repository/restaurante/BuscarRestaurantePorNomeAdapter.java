package com.fiap.tc.restaurantes.infra.adapter.repository.restaurante;

import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorNomeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarRestaurantePorNomeAdapter implements BuscarRestaurantePorNomeInterface {
  private final RestauranteRepository restauranteRepository;
  private final RestauranteEntityMapper restauranteMapper;

  @Override
  public List<Restaurante> buscarRestaurantePorNome(String nome) {
    return restauranteRepository.findByNomeContaining(nome).stream().map(restauranteMapper::toRestaurante).toList();
  }
}
