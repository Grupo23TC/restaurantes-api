package com.fiap.tc.restaurantes.infra.config.mesa;

import com.fiap.tc.restaurantes.domain.usecase.mesa.BuscarMesaPorIdUseCase;
import com.fiap.tc.restaurantes.domain.gateway.mesa.BuscarMesaPorIdInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarMesaPorIdConfig {
    @Bean
    public BuscarMesaPorIdUseCase buscarMesaPorIdUseCase(BuscarMesaPorIdInterface buscarMesaPorIdInterface) {
        return new BuscarMesaPorIdUseCase(buscarMesaPorIdInterface);
    }
}