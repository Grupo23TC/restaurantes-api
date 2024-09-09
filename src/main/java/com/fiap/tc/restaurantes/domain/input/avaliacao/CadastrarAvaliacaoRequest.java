package com.fiap.tc.restaurantes.domain.input.avaliacao;

public record CadastrarAvaliacaoRequest(
        Long restauranteId,
        Long usuarioId,
        Integer nota,
        String comentario
) {
}
