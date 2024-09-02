package com.fiap.tc.restaurantes.config.restaurante;

import com.fiap.tc.restaurantes.application.core.usecase.restaurante.BuscarRestaurantePorTipoCozinhaUseCase;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.BuscarRestaurantePorTipoCozinhaOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestaurantePorTipoCozinhaConfig {

  @Bean
  public BuscarRestaurantePorTipoCozinhaUseCase buscarRestaurantePorTipoCozinhaUseCase(
      BuscarRestaurantePorTipoCozinhaOutputPort buscarRestaurantePorTipoCozinhaOutputPort
  ) {
    return new BuscarRestaurantePorTipoCozinhaUseCase(buscarRestaurantePorTipoCozinhaOutputPort);
  }
}
