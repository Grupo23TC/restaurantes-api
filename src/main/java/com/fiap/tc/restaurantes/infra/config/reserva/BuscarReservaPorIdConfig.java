package com.fiap.tc.restaurantes.infra.config.reserva;

import com.fiap.tc.restaurantes.domain.gateway.reserva.BuscarReservaPorIdInterface;
import com.fiap.tc.restaurantes.domain.usecase.reserva.BuscarReservaPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarReservaPorIdConfig {
    @Bean
    BuscarReservaPorIdUseCase buscarReservaPorIdUseCase(BuscarReservaPorIdInterface buscarReservaPorIdInterface) {
        return new BuscarReservaPorIdUseCase(buscarReservaPorIdInterface);
    }
}
