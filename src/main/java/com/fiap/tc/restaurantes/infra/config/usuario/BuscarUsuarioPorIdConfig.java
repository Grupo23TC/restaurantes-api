package com.fiap.tc.restaurantes.infra.config.usuario;

import com.fiap.tc.restaurantes.domain.useCase.usuario.BuscarUsuarioPorIdUseCase;
import com.fiap.tc.restaurantes.domain.gateway.usuario.BuscarUsuarioPorIdInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarUsuarioPorIdConfig {
  @Bean
  public BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase(BuscarUsuarioPorIdInterface buscarUsuarioPorIdInterface) {
    return new BuscarUsuarioPorIdUseCase(buscarUsuarioPorIdInterface);
  }
}
