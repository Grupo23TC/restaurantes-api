package com.fiap.tc.restaurantes.domain.gateway.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;

import java.util.List;

public interface ListarMesasInterface {
    List<Mesa> listarMesasPorRestaurante(Long restauranteId);

    List<Mesa> listarMesas();
}