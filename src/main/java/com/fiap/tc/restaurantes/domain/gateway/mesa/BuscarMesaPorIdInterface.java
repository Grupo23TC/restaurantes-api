package com.fiap.tc.restaurantes.domain.gateway.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;

public interface BuscarMesaPorIdInterface {
    Mesa buscarPorId(Long mesaId);
}