package com.fiap.tc.restaurantes.config.restaurante;

import com.fiap.tc.restaurantes.application.core.usecase.restaurante.AtualizarRestauranteUseCase;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.AtualizarRestauranteOutputPort;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.ConsultarEnderecoPorCepOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarRestauranteConfig {

  /**
   * @param atualizarRestauranteOutputPort
   * @param consultarEnderecoPorCepOutputPort
   * @return
   */
  @Bean
  public AtualizarRestauranteUseCase atualizarRestauranteUseCase(AtualizarRestauranteOutputPort atualizarRestauranteOutputPort,
                                                                 ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort) {
    return new AtualizarRestauranteUseCase(atualizarRestauranteOutputPort, consultarEnderecoPorCepOutputPort);
  }
}
