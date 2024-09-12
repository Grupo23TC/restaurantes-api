package com.fiap.tc.restaurantes.infra.adapter.repository.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorRestauranteInterface;
import com.fiap.tc.restaurantes.infra.entity.AvaliacaoEntity;
import com.fiap.tc.restaurantes.infra.repository.AvaliacaoRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.AvaliacaoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BuscarAvaliacoesPorRestauranteAdapter implements BuscarAvaliacoesPorRestauranteInterface {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoEntityMapper mapper;

    @Override
    public List<Avaliacao> buscarAvaliacoesPorRestaurante(Long restauranteId) {
        List<AvaliacaoEntity> avaliacoes = avaliacaoRepository.buscarPorRestaurante(restauranteId);
        return avaliacoes.stream().map(mapper::toAvaliacao).toList();
    }
}
