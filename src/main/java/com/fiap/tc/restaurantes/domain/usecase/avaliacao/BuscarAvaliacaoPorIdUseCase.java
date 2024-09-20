package com.fiap.tc.restaurantes.domain.usecase.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.exception.avaliacao.AvaliacaoNotFoundException;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacaoPorIdInterface;

public class BuscarAvaliacaoPorIdUseCase {

    private final BuscarAvaliacaoPorIdInterface buscarAvaliacaoPorIdInterface;

    public BuscarAvaliacaoPorIdUseCase(BuscarAvaliacaoPorIdInterface buscarAvaliacaoPorIdInterface) {
        this.buscarAvaliacaoPorIdInterface = buscarAvaliacaoPorIdInterface;
    }

    public Avaliacao buscarAvaliacaoPorId(Long id) {

        Avaliacao avaliacao = buscarAvaliacaoPorIdInterface.buscarAvaliacaoPorId(id);
        if (avaliacao == null) {
            throw new AvaliacaoNotFoundException("Avaliação de id: " + id + " não encontrada.");
        }

        return avaliacao;
    }
}
