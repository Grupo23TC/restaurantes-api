package com.fiap.tc.restaurantes.infra.config.restaurante;

import com.fiap.tc.restaurantes.domain.usecase.restaurante.ListarRestauranteUseCase;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.ListarRestauranteInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarRestauranteConfig {

  /**
   * @param outputPort
   * @return
   */
  @Bean
  public ListarRestauranteUseCase listarRestauranteUseCase(ListarRestauranteInterface outputPort) {
    return new ListarRestauranteUseCase(outputPort);
  }
}
