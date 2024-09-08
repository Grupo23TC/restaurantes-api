package com.fiap.tc.restaurantes.domain.gateway.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;

public interface AtualizarMesaInterface {
    Mesa atualizarMesa(Long restauranteId, Long mesaId, Mesa mesa);
}
