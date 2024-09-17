package com.fiap.tc.restaurantes.domain.gateway.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;

import java.util.List;

public interface BuscarAvaliacoesPorUsuarioInterface {

    List<Avaliacao> buscarAvaliacoesPorUsuario(Long usuarioId);
}
