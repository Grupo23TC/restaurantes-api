package com.fiap.tc.restaurantes.domain.usecase.reserva;

import com.fiap.tc.restaurantes.domain.entity.Reserva;
import com.fiap.tc.restaurantes.domain.gateway.reserva.BuscarReservasPorMesaEPeriodoInterface;

import java.time.LocalDateTime;
import java.util.List;

public class BuscarReservasPorMesaEPeriodoUseCase {

    private BuscarReservasPorMesaEPeriodoInterface buscarReservasPorMesaEPeriodoInterface;

    public BuscarReservasPorMesaEPeriodoUseCase(BuscarReservasPorMesaEPeriodoInterface buscarReservasPorMesaEPeriodoInterface) {
        this.buscarReservasPorMesaEPeriodoInterface = buscarReservasPorMesaEPeriodoInterface;
    }

    public List<Reserva> buscarReservasPorMesaEPeriodo(Long mesaId, LocalDateTime dataInicio, LocalDateTime dataFim) {
        return buscarReservasPorMesaEPeriodoInterface.buscarReservasPorMesaEPeriodo(mesaId, dataInicio, dataFim);
    }
}
