package com.fiap.tc.restaurantes.domain.usecase.avaliacao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.DeletarAvaliacaoInterface;

public class DeletarAvaliacaoUseCase {

    private final DeletarAvaliacaoInterface deletarAvaliacaoInterface;
    private final BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase;

    public DeletarAvaliacaoUseCase(DeletarAvaliacaoInterface deletarAvaliacaoInterface, BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase) {
        this.deletarAvaliacaoInterface = deletarAvaliacaoInterface;
        this.buscarAvaliacaoPorIdUseCase = buscarAvaliacaoPorIdUseCase;
    }

    public boolean execute(Long avaliacaoId) {

        //Valida se avaliacao existe
        buscarAvaliacaoPorIdUseCase.buscarAvalacaoPorId(avaliacaoId);

        try {
            deletarAvaliacaoInterface.deletarAvaliacao(avaliacaoId);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
