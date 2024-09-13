package com.fiap.tc.restaurantes.infra.config.usuario;

import com.fiap.tc.restaurantes.domain.usecase.usuario.AtualizarUsuarioUseCase;
import com.fiap.tc.restaurantes.domain.gateway.usuario.AtualizarUsuarioInterface;
import com.fiap.tc.restaurantes.domain.usecase.usuario.BuscarUsuarioPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarUsuarioConfig {
  @Bean
  public AtualizarUsuarioUseCase atualizarUsuarioUseCase(
      AtualizarUsuarioInterface atualizarUsuarioInterface,
      BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase
  ) {
    return new AtualizarUsuarioUseCase(atualizarUsuarioInterface, buscarUsuarioPorIdUseCase);
  }
}
