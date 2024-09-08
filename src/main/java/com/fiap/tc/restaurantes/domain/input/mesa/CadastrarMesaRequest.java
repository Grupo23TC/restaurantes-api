package com.fiap.tc.restaurantes.domain.input.mesa;

public record CadastrarMesaRequest(
    Long restauranteId,
    Integer quantidadeAssentos
) {
}
