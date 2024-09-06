package com.fiap.tc.restaurantes.config.restaurante;

import com.fiap.tc.restaurantes.application.core.usecase.restaurante.BuscarRestaurantePorLocalidadeUseCase;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.BuscarRestaurantePorLocalidadeOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorLocalidadeConfig {

  @Bean
  public BuscarRestaurantePorLocalidadeUseCase buscarRestaurantesPorLocalidadeUseCase(
          BuscarRestaurantePorLocalidadeOutputPort buscarRestaurantePorLocalidadeOutputPort
  ) {
    return new BuscarRestaurantePorLocalidadeUseCase(buscarRestaurantePorLocalidadeOutputPort);
  }
}
