package com.fiap.tc.restaurantes.domain.gateway.mesa;

public interface DeletarMesaInterface {
    void deletarMesa(Long restauranteId, Long mesaId);
}