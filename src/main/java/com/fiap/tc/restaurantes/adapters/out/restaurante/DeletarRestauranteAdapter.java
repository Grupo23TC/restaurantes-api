package com.fiap.tc.restaurantes.adapters.out.restaurante;

import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.mapper.RestauranteMapper;
import com.fiap.tc.restaurantes.adapters.out.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.DeletarRestauranteOutputPort;
import org.springframework.stereotype.Component;

@Component
public class DeletarRestauranteAdapter implements DeletarRestauranteOutputPort {
  private final RestauranteRepository restauranteRepository;
  private final RestauranteMapper restauranteMapper;

  public DeletarRestauranteAdapter(RestauranteRepository restauranteRepository, RestauranteMapper restauranteMapper) {
    this.restauranteRepository = restauranteRepository;
    this.restauranteMapper = restauranteMapper;
  }

  @Override
  public boolean deletarRestaurante(Long id) {
    // TODO implementar verificacao se restaurante existe
    restauranteRepository.deleteById(id);
    return true;
  }
}
