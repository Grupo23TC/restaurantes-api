package com.fiap.tc.restaurantes.domain.usecase.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.gateway.mesa.ListarMesasPorRestauranteInterface;

import java.util.List;

public class ListarMesasPorRestauranteUseCase {

    private final ListarMesasPorRestauranteInterface listarMesasPorRestauranteInterface;

    public ListarMesasPorRestauranteUseCase(ListarMesasPorRestauranteInterface listarMesasPorRestauranteInterface) {
        this.listarMesasPorRestauranteInterface = listarMesasPorRestauranteInterface;
    }

    public List<Mesa> listarMesasPorRestaurante(Long restauranteId) {
        return listarMesasPorRestauranteInterface.listarMesasPorRestaurante(restauranteId);
    }
}