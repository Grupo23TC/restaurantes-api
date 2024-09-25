package com.fiap.tc.restaurantes.infra.config.reserva;

import com.fiap.tc.restaurantes.domain.gateway.reserva.BuscarReservasPorMesaInterface;
import com.fiap.tc.restaurantes.domain.usecase.reserva.BuscarReservasPorMesaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarReservasPorMesaConfig {
    @Bean
    BuscarReservasPorMesaUseCase buscarReservasPorMesaUseCase(BuscarReservasPorMesaInterface buscarReservasPorMesaInterface) {
        return new BuscarReservasPorMesaUseCase(buscarReservasPorMesaInterface);
    }
}
