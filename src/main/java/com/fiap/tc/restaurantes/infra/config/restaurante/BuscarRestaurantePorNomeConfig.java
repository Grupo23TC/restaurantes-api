package com.fiap.tc.restaurantes.infra.config.restaurante;

import com.fiap.tc.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorNomeUseCase;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorNomeInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorNomeConfig {

  @Bean
  public BuscarRestaurantePorNomeUseCase buscarRestaurantesPorNomeUseCase(
      BuscarRestaurantePorNomeInterface buscarRestaurantePorNomeInterface
  ) {
    return new BuscarRestaurantePorNomeUseCase(buscarRestaurantePorNomeInterface);
  }
}
