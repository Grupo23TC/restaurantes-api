package com.fiap.tc.restaurantes.infra.adapter.repository.avaliacao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.DeletarAvaliacaoInterface;
import com.fiap.tc.restaurantes.infra.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeletarAvaliacaoAdapter implements DeletarAvaliacaoInterface {

    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public boolean deletarAvaliacao(Long avaliacaoId) {
        try {
            avaliacaoRepository.deleteById(avaliacaoId);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
