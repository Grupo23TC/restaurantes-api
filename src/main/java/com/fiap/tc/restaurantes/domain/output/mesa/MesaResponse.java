package com.fiap.tc.restaurantes.domain.output.mesa;

import com.fiap.tc.restaurantes.domain.enums.StatusMesaEnum;

public record MesaResponse(Long id,
                           Long restauranteId,
                           int capacidade,
                           StatusMesaEnum status ) {

}
