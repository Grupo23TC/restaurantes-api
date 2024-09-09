package com.fiap.tc.restaurantes.infra.adapter.repository.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.CadastrarAvaliacaoInterface;
import com.fiap.tc.restaurantes.infra.entity.AvaliacaoEntity;
import com.fiap.tc.restaurantes.infra.repository.AvaliacaoRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.AvaliacaoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarAvaliacaoAdapter implements CadastrarAvaliacaoInterface {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoEntityMapper mapper;

    @Override
    public Avaliacao cadastraAvaliacao(Avaliacao avaliacao) {
        AvaliacaoEntity avaliacaoEntity = avaliacaoRepository.save(mapper.toAvaliacaoEntity(avaliacao));
        return mapper.toAvaliacao(avaliacaoEntity);
    }
}
