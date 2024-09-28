package com.fiap.tc.restaurantes.infra.adapter.repository.restaurante;

import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.DeletarRestauranteInterface;
import org.springframework.stereotype.Component;

@Component
public class DeletarRestauranteAdapter implements DeletarRestauranteInterface {
  private final RestauranteRepository restauranteRepository;

  public DeletarRestauranteAdapter(RestauranteRepository restauranteRepository) {
    this.restauranteRepository = restauranteRepository;
  }

  @Override
  public boolean deletarRestaurante(Long id) {
    restauranteRepository.deleteById(id);
    return true;
  }
}
