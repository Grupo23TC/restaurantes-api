package com.fiap.tc.restaurantes.config.restaurante;

import com.fiap.tc.restaurantes.application.core.usecase.restaurante.BuscarRestaurantesPorNomeUseCase;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.BuscarRestaurantePorNomeOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorNomeConfig {

  @Bean
  public BuscarRestaurantesPorNomeUseCase buscarRestaurantesPorNomeUseCase(
      BuscarRestaurantePorNomeOutputPort buscarRestaurantePorNomeOutputPort
  ) {
    return new BuscarRestaurantesPorNomeUseCase(buscarRestaurantePorNomeOutputPort);
  }
}
