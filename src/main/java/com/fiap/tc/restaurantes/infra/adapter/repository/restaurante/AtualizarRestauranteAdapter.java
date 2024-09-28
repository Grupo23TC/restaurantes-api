package com.fiap.tc.restaurantes.infra.adapter.repository.restaurante;

import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.infra.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.AtualizarRestauranteInterface;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AtualizarRestauranteAdapter implements AtualizarRestauranteInterface {

  private final RestauranteRepository restauranteRepository;
  private final RestauranteEntityMapper entityMapper;

  @Override
  @Transactional
  public Restaurante atualizarRestaurante(Restaurante restaurante) {

    RestauranteEntity restauranteAtualizado = restauranteRepository.save(entityMapper.toRestauranteEntity(restaurante));

    return entityMapper.toRestaurante(restauranteAtualizado);
  }
}
