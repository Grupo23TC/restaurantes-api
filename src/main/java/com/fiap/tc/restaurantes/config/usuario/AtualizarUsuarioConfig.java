package com.fiap.tc.restaurantes.config.usuario;

import com.fiap.tc.restaurantes.application.core.usecase.usuario.AtualizarUsuarioUseCase;
import com.fiap.tc.restaurantes.application.ports.out.usuario.AtualizarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarUsuarioConfig {
  @Bean
  public AtualizarUsuarioUseCase atualizarUsuarioUseCase(AtualizarUsuarioOutputPort atualizarUsuarioOutputPort) {
    return new AtualizarUsuarioUseCase(atualizarUsuarioOutputPort);
  }
}
