package com.fiap.tc.restaurantes.config.restaurante;

import com.fiap.tc.restaurantes.application.core.usecase.restaurante.ListarRestauranteUseCase;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.ListarRestauranteOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarRestauranteConfig {

  /**
   * @param outputPort
   * @return
   */
  @Bean
  public ListarRestauranteUseCase listarRestauranteUseCase(ListarRestauranteOutputPort outputPort) {
    return new ListarRestauranteUseCase(outputPort);
  }
}
