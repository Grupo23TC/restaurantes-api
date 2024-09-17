package com.fiap.tc.restaurantes.domain.input.avaliacao;

public record AtualizarAvaliacaoRequest(
        Integer nota,
        String comentario
) {
}
