package com.fiap.tc.restaurantes.domain.useCase.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.gateway.mesa.ListarMesasInterface;

import java.util.List;

public class ListarMesasUseCase {

    private final ListarMesasInterface listarMesasInterface;

    public ListarMesasUseCase(ListarMesasInterface listarMesasInterface) {
        this.listarMesasInterface = listarMesasInterface;
    }

    public List<Mesa> listarMesasPorRestaurante(Long restauranteId) {
        return listarMesasInterface.listarMesasPorRestaurante(restauranteId);
    }

    public List<Mesa> listarMesas() {
    }
}