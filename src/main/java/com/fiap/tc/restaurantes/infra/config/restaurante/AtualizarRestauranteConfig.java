package com.fiap.tc.restaurantes.infra.config.restaurante;

import com.fiap.tc.restaurantes.domain.useCase.restaurante.AtualizarRestauranteUseCase;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.AtualizarRestauranteInterface;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarRestauranteConfig {

  /**
   * @param atualizarRestauranteInterface
   * @param consultarEnderecoPorCepInterface
   * @return
   */
  @Bean
  public AtualizarRestauranteUseCase atualizarRestauranteUseCase(AtualizarRestauranteInterface atualizarRestauranteInterface,
                                                                 ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface) {
    return new AtualizarRestauranteUseCase(atualizarRestauranteInterface, consultarEnderecoPorCepInterface);
  }
}
