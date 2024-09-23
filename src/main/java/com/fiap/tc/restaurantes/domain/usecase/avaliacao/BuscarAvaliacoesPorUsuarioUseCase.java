package com.fiap.tc.restaurantes.domain.usecase.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorUsuarioInterface;

import java.util.List;

public class BuscarAvaliacoesPorUsuarioUseCase {

    private final BuscarAvaliacoesPorUsuarioInterface buscarAvaliacoesPorUsuarioInterface;

    public BuscarAvaliacoesPorUsuarioUseCase(BuscarAvaliacoesPorUsuarioInterface buscarAvaliacoesPorUsuarioInterface) {
        this.buscarAvaliacoesPorUsuarioInterface = buscarAvaliacoesPorUsuarioInterface;
    }

    public List<Avaliacao> buscarAvaliacoesPorUsuario(Long usuarioId) {
        return buscarAvaliacoesPorUsuarioInterface.buscarAvaliacoesPorUsuario(usuarioId);
    }
}
