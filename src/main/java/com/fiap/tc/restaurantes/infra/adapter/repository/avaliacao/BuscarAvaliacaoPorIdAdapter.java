package com.fiap.tc.restaurantes.infra.adapter.repository.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacaoPorIdInterface;
import com.fiap.tc.restaurantes.infra.repository.AvaliacaoRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.AvaliacaoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BuscarAvaliacaoPorIdAdapter implements BuscarAvaliacaoPorIdInterface {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoEntityMapper mapper;

    @Override
    public Avaliacao buscarAvaliacaoPorId(Long id) {
        return mapper.toAvaliacao(avaliacaoRepository.findById(id).orElse(null));
    }
}
