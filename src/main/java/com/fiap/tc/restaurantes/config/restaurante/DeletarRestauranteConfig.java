package com.fiap.tc.restaurantes.config.restaurante;

import com.fiap.tc.restaurantes.application.core.usecase.restaurante.DeletarRestauranteUseCase;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.DeletarRestauranteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarRestauranteConfig {

  @Bean
  public DeletarRestauranteUseCase deletarRestauranteUseCase(DeletarRestauranteOutputPort outputPort) {
    return new DeletarRestauranteUseCase(outputPort);
  }
}
