package com.fiap.tc.restaurantes.config.usuario;

import com.fiap.tc.restaurantes.application.core.usecase.usuario.DeletarUsuarioUseCase;
import com.fiap.tc.restaurantes.application.ports.out.usuario.DeletarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarUsuarioConfig {
  @Bean
  public DeletarUsuarioUseCase deletarUsuarioUseCase(DeletarUsuarioOutputPort deletarUsuarioOutputPort) {
    return new DeletarUsuarioUseCase(deletarUsuarioOutputPort);
  }
}
