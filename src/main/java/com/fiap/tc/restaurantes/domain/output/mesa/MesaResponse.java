package com.fiap.tc.restaurantes.domain.output.mesa;

public record MesaResponse(Long id,
                           String descricao,
                           int capacidade,
                           boolean disponivel ) {

}
