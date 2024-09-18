package com.fiap.tc.restaurantes.domain.input.mesa;

import com.fiap.tc.restaurantes.domain.enums.StatusMesaEnum;

public record AtualizarMesaRequest(
        StatusMesaEnum status,
        Integer quantidadeAssentos
) {

}