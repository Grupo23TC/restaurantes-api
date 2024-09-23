package com.fiap.tc.restaurantes.domain.gateway.reserva;

import com.fiap.tc.restaurantes.domain.entity.Reserva;

import java.util.List;

public interface BuscarReservasPorUsuarioInterface {

    List<Reserva> buscarReservasPorUsuario(Long usuarioId);
}
