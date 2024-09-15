package com.fiap.tc.restaurantes.domain.useCase.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.gateway.mesa.AtualizarMesaInterface;

public class AtualizarMesaUseCase {

    private final AtualizarMesaInterface atualizarMesaInterface;

    public AtualizarMesaUseCase(AtualizarMesaInterface atualizarMesaInterface) {
        this.atualizarMesaInterface = atualizarMesaInterface;
    }

    public Mesa atualizarMesa(Long restauranteId, Long mesaId, Mesa mesa) {
        return atualizarMesaInterface.atualizarMesa(restauranteId, mesaId, mesa);
    }

}