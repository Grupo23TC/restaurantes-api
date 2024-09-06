package com.fiap.tc.restaurantes.config.restaurante;

import com.fiap.tc.restaurantes.application.core.usecase.restaurante.BuscarRestaurantePorNomeUseCase;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.BuscarRestaurantePorNomeOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorNomeConfig {

  @Bean
  public BuscarRestaurantePorNomeUseCase buscarRestaurantesPorNomeUseCase(
      BuscarRestaurantePorNomeOutputPort buscarRestaurantePorNomeOutputPort
  ) {
    return new BuscarRestaurantePorNomeUseCase(buscarRestaurantePorNomeOutputPort);
  }
}
