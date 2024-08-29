package com.fiap.tc.restaurantes.adapters.out.restaurante;

import com.fiap.tc.restaurantes.adapters.out.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.BuscarRestaurantePorNomeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarRestaurantePorNomeAdapter implements BuscarRestaurantePorNomeOutputPort {
  private final RestauranteRepository restauranteRepository;
  private final RestauranteEntityMapper restauranteMapper;

  @Override
  public List<Restaurante> buscarRestaurantePorNome(String nome) {
    return restauranteRepository.findByNomeContaining(nome).stream().map(restauranteMapper::toRestaurante).toList();
  }
}
