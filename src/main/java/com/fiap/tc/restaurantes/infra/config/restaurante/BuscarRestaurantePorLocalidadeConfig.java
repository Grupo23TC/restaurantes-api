package com.fiap.tc.restaurantes.infra.config.restaurante;

import com.fiap.tc.restaurantes.domain.useCase.restaurante.BuscarRestaurantePorLocalidadeUseCase;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorLocalidadeInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorLocalidadeConfig {

  @Bean
  public BuscarRestaurantePorLocalidadeUseCase buscarRestaurantesPorLocalidadeUseCase(
          BuscarRestaurantePorLocalidadeInterface buscarRestaurantePorLocalidadeInterface
  ) {
    return new BuscarRestaurantePorLocalidadeUseCase(buscarRestaurantePorLocalidadeInterface);
  }
}
