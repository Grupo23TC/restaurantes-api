package com.fiap.tc.restaurantes.domain.usecase.reserva;

import com.fiap.tc.restaurantes.domain.entity.Reserva;
import com.fiap.tc.restaurantes.domain.gateway.reserva.BuscarReservasPorMesaInterface;

import java.util.List;

public class BuscarReservasPorMesaUseCase {

    private final BuscarReservasPorMesaInterface buscarReservasPorMesaInterface;

    public BuscarReservasPorMesaUseCase(BuscarReservasPorMesaInterface buscarReservasPorMesaInterface) {
        this.buscarReservasPorMesaInterface = buscarReservasPorMesaInterface;
    }

    public List<Reserva> buscarReservasPorMesa(Long mesaId) {
        return buscarReservasPorMesaInterface.buscarReservasPorMesa(mesaId);
    }
}
