package com.fiap.tc.restaurantes.infra.config.mesa;

import com.fiap.tc.restaurantes.domain.usecase.mesa.CadastrarMesaUseCase;
import com.fiap.tc.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarMesaConfig {

  @Bean
  public CadastrarMesaUseCase cadastrarMesaUseCase(CadastrarMesaInterface cadastrarMesaInterface) {
    return new CadastrarMesaUseCase(cadastrarMesaInterface);
  }
}