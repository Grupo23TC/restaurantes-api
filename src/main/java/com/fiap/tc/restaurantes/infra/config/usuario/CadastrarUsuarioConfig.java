package com.fiap.tc.restaurantes.infra.config.usuario;

import com.fiap.tc.restaurantes.domain.usecase.usuario.CadastrarUsuarioUseCase;
import com.fiap.tc.restaurantes.domain.gateway.usuario.CadastrarUsuarioInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarUsuarioConfig {

  @Bean
  public CadastrarUsuarioUseCase cadastrarUsuarioUseCase(CadastrarUsuarioInterface cadastrarUsuarioInterface) {
    return new CadastrarUsuarioUseCase(cadastrarUsuarioInterface);
  }
}
