package com.fiap.tc.restaurantes.infra.adapter.repository.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorIdInterface;
import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.RestauranteEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BuscarRestaurantePorIdAdapter implements BuscarRestaurantePorIdInterface {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper mapper;

    @Override
    public Restaurante buscarRestaurantePorId(Long id) {
        RestauranteEntity restauranteEntity = restauranteRepository.findById(id).orElse(null);
        return mapper.toRestaurante(restauranteEntity);
    }
}
