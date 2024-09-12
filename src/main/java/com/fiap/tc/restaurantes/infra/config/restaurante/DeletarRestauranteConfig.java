package com.fiap.tc.restaurantes.infra.config.restaurante;

import com.fiap.tc.restaurantes.domain.usecase.restaurante.DeletarRestauranteUseCase;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.DeletarRestauranteInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarRestauranteConfig {

  @Bean
  public DeletarRestauranteUseCase deletarRestauranteUseCase(DeletarRestauranteInterface outputPort) {
    return new DeletarRestauranteUseCase(outputPort);
  }
}
