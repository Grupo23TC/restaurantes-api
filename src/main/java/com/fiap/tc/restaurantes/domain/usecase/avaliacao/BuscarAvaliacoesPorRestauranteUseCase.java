package com.fiap.tc.restaurantes.domain.usecase.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorRestauranteInterface;

import java.util.List;

public class BuscarAvaliacoesPorRestauranteUseCase {

    private final BuscarAvaliacoesPorRestauranteInterface buscarAvaliacoesPorRestaurante;

    public BuscarAvaliacoesPorRestauranteUseCase(BuscarAvaliacoesPorRestauranteInterface buscarAvaliacoesPorRestaurante) {
        this.buscarAvaliacoesPorRestaurante = buscarAvaliacoesPorRestaurante;
    }

    public List<Avaliacao> buscarAvaliacoesPorRestaurante(Long restauranteId) {
        return buscarAvaliacoesPorRestaurante.buscarAvaliacoesPorRestaurante(restauranteId);
    }
}
