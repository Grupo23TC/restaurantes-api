package com.fiap.tc.restaurantes.domain.gateway.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;

public interface BuscarRestaurantePorIdInterface {

    Restaurante buscarRestaurantePorId(Long id);
}
