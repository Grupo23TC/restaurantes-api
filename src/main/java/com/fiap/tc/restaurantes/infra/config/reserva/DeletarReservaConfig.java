package com.fiap.tc.restaurantes.infra.config.reserva;

import com.fiap.tc.restaurantes.domain.gateway.reserva.DeletarReservaInterface;
import com.fiap.tc.restaurantes.domain.usecase.reserva.BuscarReservaPorIdUseCase;
import com.fiap.tc.restaurantes.domain.usecase.reserva.DeletarReservaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarReservaConfig {
    @Bean
    DeletarReservaUseCase deletarReservaUseCase(DeletarReservaInterface deletarReservaInterface, BuscarReservaPorIdUseCase buscarReservaPorIdUseCase) {
        return new DeletarReservaUseCase(buscarReservaPorIdUseCase, deletarReservaInterface);
    }
}
