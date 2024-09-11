package com.fiap.tc.restaurantes.infra.config.restaurante;

import com.fiap.tc.restaurantes.domain.useCase.restaurante.BuscarRestaurantePorTipoCozinhaUseCase;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorTipoCozinhaInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorTipoCozinhaConfig {

  @Bean
  public BuscarRestaurantePorTipoCozinhaUseCase buscarRestaurantePorTipoCozinhaUseCase(
      BuscarRestaurantePorTipoCozinhaInterface buscarRestaurantePorTipoCozinhaInterface
  ) {
    return new BuscarRestaurantePorTipoCozinhaUseCase(buscarRestaurantePorTipoCozinhaInterface);
  }
}
