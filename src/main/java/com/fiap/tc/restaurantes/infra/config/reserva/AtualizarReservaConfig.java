package com.fiap.tc.restaurantes.infra.config.reserva;

import com.fiap.tc.restaurantes.domain.gateway.reserva.AtualizarReservaInterface;
import com.fiap.tc.restaurantes.domain.usecase.reserva.AtualizarReservaUseCase;
import com.fiap.tc.restaurantes.domain.usecase.reserva.BuscarReservaPorIdUseCase;

import com.fiap.tc.restaurantes.domain.usecase.reserva.BuscarReservasPorMesaEPeriodoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarReservaConfig {
    @Bean
    AtualizarReservaUseCase atualizarReservaUseCase(BuscarReservaPorIdUseCase buscarReservaPorIdUseCase,
                                                    AtualizarReservaInterface atualizarReservaInterface,
                                                    BuscarReservasPorMesaEPeriodoUseCase buscarReservasPorMesaEPeriodoUseCase) {
        return new AtualizarReservaUseCase(buscarReservaPorIdUseCase, atualizarReservaInterface, buscarReservasPorMesaEPeriodoUseCase);
    }
}
