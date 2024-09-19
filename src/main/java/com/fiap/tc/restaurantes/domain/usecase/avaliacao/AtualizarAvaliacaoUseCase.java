package com.fiap.tc.restaurantes.domain.usecase.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.entity.validations.AvaliacaoValidation;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.AtualizarAvaliacaoInterface;

public class AtualizarAvaliacaoUseCase {

    private final AtualizarAvaliacaoInterface atualizarAvaliacaoInterface;
    private final BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase;

    public AtualizarAvaliacaoUseCase(AtualizarAvaliacaoInterface atualizarAvaliacaoInterface, BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase) {
        this.atualizarAvaliacaoInterface = atualizarAvaliacaoInterface;
        this.buscarAvaliacaoPorIdUseCase = buscarAvaliacaoPorIdUseCase;
    }

    public Avaliacao atualizarAvaliacao(Long id, Avaliacao avaliacaoNova) {

        Avaliacao avaliacao = buscarAvaliacaoPorIdUseCase.buscarAvalacaoPorId(id);

        avaliacao.setNota(avaliacaoNova.getNota());
        avaliacao.setComentario(avaliacaoNova.getComentario());

        AvaliacaoValidation.validate(avaliacao);

        return atualizarAvaliacaoInterface.atualizarAvaliacao(avaliacao);

    }
}
