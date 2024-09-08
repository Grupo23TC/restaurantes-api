package com.fiap.tc.restaurantes.domain.useCase.mesa;

import com.fiap.tc.restaurantes.domain.gateway.mesa.DeletarMesaInterface;

public class DeletarMesaUseCase {

    private final DeletarMesaInterface deletarMesaInterface;

    public DeletarMesaUseCase(DeletarMesaInterface deletarMesaInterface) {
        this.deletarMesaInterface = deletarMesaInterface;
    }

    public void deletarMesa(Long restauranteId, Long mesaId) {
        deletarMesaInterface.deletarMesa(restauranteId, mesaId);
    }
}