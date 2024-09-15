package com.fiap.tc.restaurantes.domain.gateway.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.infra.entity.MesaEntity;

public interface AtualizarMesaInterface {

    Mesa atualizarMesa(Long restauranteId, Long mesaId,Mesa mesa);

    MesaEntity buscarMesa(Long mesaId);
}
