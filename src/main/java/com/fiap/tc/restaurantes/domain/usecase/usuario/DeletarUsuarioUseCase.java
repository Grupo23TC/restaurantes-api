package com.fiap.tc.restaurantes.domain.usecase.usuario;


import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.entity.Reserva;
import com.fiap.tc.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorUsuarioUseCase;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.DeletarAvaliacaoUseCase;
import com.fiap.tc.restaurantes.domain.usecase.reserva.BuscarReservasPorUsuarioUseCase;
import com.fiap.tc.restaurantes.domain.usecase.reserva.DeletarReservaUseCase;

import java.util.List;

public class DeletarUsuarioUseCase {
  private final DeletarUsuarioInterface deletarUsuarioInterface;
  private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;
  private final BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase;
  private final DeletarAvaliacaoUseCase deletarAvaliacaoUseCase;
  private final BuscarReservasPorUsuarioUseCase buscarReservasPorUsuarioUseCase;
  private final DeletarReservaUseCase deletarReservaUseCase;

  public DeletarUsuarioUseCase(
      DeletarUsuarioInterface deletarUsuarioInterface,
      BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase,
      BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase,
      DeletarAvaliacaoUseCase deletarAvaliacaoUseCase,
      BuscarReservasPorUsuarioUseCase buscarReservasPorUsuarioUseCase,
      DeletarReservaUseCase deletarReservaUseCase
  ) {
    this.deletarUsuarioInterface = deletarUsuarioInterface;
    this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
    this.buscarAvaliacoesPorUsuarioUseCase = buscarAvaliacoesPorUsuarioUseCase;
    this.deletarAvaliacaoUseCase = deletarAvaliacaoUseCase;
    this.buscarReservasPorUsuarioUseCase = buscarReservasPorUsuarioUseCase;
    this.deletarReservaUseCase = deletarReservaUseCase;
  }

  public boolean deletarUsuario(Long id) {
    buscarUsuarioPorIdUseCase.buscarUsuarioPorId(id);

    List<Avaliacao> avaliacoes = buscarAvaliacoesPorUsuarioUseCase.buscarAvaliacoesPorUsuario(id);

    avaliacoes.forEach(avaliacao -> deletarAvaliacaoUseCase.deletarAvaliacao(avaliacao.getAvaliacaoId()));

    List<Reserva> reservas = buscarReservasPorUsuarioUseCase.buscarReservasPorUsuario(id);

    reservas.forEach(reserva -> deletarReservaUseCase.deletarReserva(reserva.getReservaId()));

    return deletarUsuarioInterface.deletarUsuario(id);
  }
}
