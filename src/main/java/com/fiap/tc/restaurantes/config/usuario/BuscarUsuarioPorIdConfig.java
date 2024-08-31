package com.fiap.tc.restaurantes.config.usuario;

import com.fiap.tc.restaurantes.application.core.usecase.usuario.BuscarUsuarioPorIdUseCase;
import com.fiap.tc.restaurantes.application.ports.out.usuario.BuscarUsuarioPorIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarUsuarioPorIdConfig {
  @Bean
  public BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase(BuscarUsuarioPorIdOutputPort buscarUsuarioPorIdOutputPort) {
    return new BuscarUsuarioPorIdUseCase(buscarUsuarioPorIdOutputPort);
  }
}
