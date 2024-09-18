package com.fiap.tc.restaurantes.domain.gateway.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;

import java.util.List;

public interface ListarMesasPorRestauranteInterface {
    List<Mesa> listarMesasPorRestaurante(Long restauranteId);
}