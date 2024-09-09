package com.fiap.tc.restaurantes.infra.config.restaurante;

import com.fiap.tc.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorIdInterface;
import com.fiap.tc.restaurantes.domain.useCase.restaurante.BuscarRestaurantePorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorIdConfig {

    @Bean
    BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase(BuscarRestaurantePorIdInterface buscarRestaurantePorIdInterface) {
        return new BuscarRestaurantePorIdUseCase(buscarRestaurantePorIdInterface);
    }
}
