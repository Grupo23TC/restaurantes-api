package com.fiap.tc.restaurantes.adapters.out.restaurante;

import com.fiap.tc.restaurantes.adapters.out.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.ListarRestauranteOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarRestauranteAdapter implements ListarRestauranteOutputPort {
  private final RestauranteRepository repository;
  private final RestauranteEntityMapper entityMapper;


  public ListarRestauranteAdapter(RestauranteRepository repository, RestauranteEntityMapper entityMapper) {
    this.repository = repository;
    this.entityMapper = entityMapper;
  }

  @Override
  public List<Restaurante> listarRestaurantes() {
    List<RestauranteEntity> restaurantesEntity = repository.findAll();

    return restaurantesEntity.stream().map(entityMapper::toRestaurante).toList();
  }
}
