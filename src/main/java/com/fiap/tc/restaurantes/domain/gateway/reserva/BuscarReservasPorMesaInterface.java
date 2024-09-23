package com.fiap.tc.restaurantes.domain.gateway.reserva;

import com.fiap.tc.restaurantes.domain.entity.Reserva;

import java.util.List;

public interface BuscarReservasPorMesaInterface {

    List<Reserva> buscarReservasPorMesa(Long mesaId);
}
