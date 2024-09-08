package com.fiap.tc.restaurantes.domain.useCase.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.gateway.mesa.BuscarMesaPorIdInterface;

public class BuscarMesaPorIdUseCase {

    private final BuscarMesaPorIdInterface buscarMesaPorIdInterface;

    public BuscarMesaPorIdUseCase(BuscarMesaPorIdInterface buscarMesaPorIdInterface) {
        this.buscarMesaPorIdInterface = buscarMesaPorIdInterface;
    }

    public Mesa buscarPorId(Long mesaId) {
        return buscarMesaPorIdInterface.buscarPorId(mesaId);
    }
}