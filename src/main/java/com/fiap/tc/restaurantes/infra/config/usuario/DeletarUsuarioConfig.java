package com.fiap.tc.restaurantes.infra.config.usuario;

import com.fiap.tc.restaurantes.domain.useCase.usuario.DeletarUsuarioUseCase;
import com.fiap.tc.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarUsuarioConfig {
  @Bean
  public DeletarUsuarioUseCase deletarUsuarioUseCase(DeletarUsuarioInterface deletarUsuarioInterface) {
    return new DeletarUsuarioUseCase(deletarUsuarioInterface);
  }
}
