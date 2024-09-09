package com.fiap.tc.restaurantes.domain.gateway.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;

public interface BuscarAvaliacaoPorIdInterface {
    Avaliacao buscarAvaliacaoPorId(Long id);
}
