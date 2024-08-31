package com.fiap.tc.restaurantes.config.usuario;

import com.fiap.tc.restaurantes.application.core.usecase.usuario.CadastrarUsuarioUseCase;
import com.fiap.tc.restaurantes.application.ports.out.usuario.CadastrarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarUsuarioConfig {

  @Bean
  public CadastrarUsuarioUseCase cadastrarUsuarioUseCase(CadastrarUsuarioOutputPort cadastrarUsuarioOutputPort) {
    return new CadastrarUsuarioUseCase(cadastrarUsuarioOutputPort);
  }
}
