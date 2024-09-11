package com.fiap.tc.restaurantes.infra.adapter.repository.restaurante;

import com.fiap.tc.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.DeletarRestauranteInterface;
import org.springframework.stereotype.Component;

@Component
public class DeletarRestauranteAdapter implements DeletarRestauranteInterface {
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
