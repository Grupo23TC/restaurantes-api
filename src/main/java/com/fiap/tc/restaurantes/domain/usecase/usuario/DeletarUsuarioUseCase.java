package com.fiap.tc.restaurantes.domain.usecase.usuario;


import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorUsuarioUseCase;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.DeletarAvaliacaoUseCase;

import java.util.List;

public class DeletarUsuarioUseCase {
  private final DeletarUsuarioInterface deletarUsuarioInterface;
  private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;
  private final BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase;
  private final DeletarAvaliacaoUseCase deletarAvaliacaoUseCase;

  public DeletarUsuarioUseCase(
      DeletarUsuarioInterface deletarUsuarioInterface,
      BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase,
      BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase,
      DeletarAvaliacaoUseCase deletarAvaliacaoUseCase
  ) {
    this.deletarUsuarioInterface = deletarUsuarioInterface;
    this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
    this.buscarAvaliacoesPorUsuarioUseCase = buscarAvaliacoesPorUsuarioUseCase;
    this.deletarAvaliacaoUseCase = deletarAvaliacaoUseCase;
  }

  public boolean deletarUsuario(Long id) {
    buscarUsuarioPorIdUseCase.buscarUsuarioPorId(id);

    List<Avaliacao> avaliacoes = buscarAvaliacoesPorUsuarioUseCase.buscarAvaliacoesPorUsuario(id);

    avaliacoes.forEach(avaliacao -> deletarAvaliacaoUseCase.deletarAvaliacao(avaliacao.getAvaliacaoId()));

    return deletarUsuarioInterface.deletarUsuario(id);
  }
}
