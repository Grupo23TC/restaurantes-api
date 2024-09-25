package com.fiap.tc.restaurantes.domain.gateway.reserva;

import com.fiap.tc.restaurantes.domain.entity.Reserva;

import java.time.LocalDateTime;
import java.util.List;

public interface BuscarReservasPorMesaEPeriodoInterface {

    List<Reserva> buscarReservasPorMesaEPeriodo(Long mesaId, LocalDateTime dataInicio, LocalDateTime dataFim);
}
