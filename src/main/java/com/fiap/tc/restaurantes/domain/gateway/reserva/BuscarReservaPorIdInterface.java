package com.fiap.tc.restaurantes.domain.gateway.reserva;

import com.fiap.tc.restaurantes.domain.entity.Reserva;

public interface BuscarReservaPorIdInterface {

    Reserva buscarReservaPorId(Long reservaId);
}
