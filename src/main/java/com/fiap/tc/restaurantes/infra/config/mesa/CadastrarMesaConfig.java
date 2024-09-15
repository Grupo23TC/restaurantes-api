package com.fiap.tc.restaurantes.infra.config.mesa;

import com.fiap.tc.restaurantes.domain.useCase.mesa.CadastrarMesaUseCase;
import com.fiap.tc.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;
import com.fiap.tc.restaurantes.infra.repository.MesaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fiap.tc.restaurantes.domain.useCase.mesa.CadastrarMesaUseCase;
import com.fiap.tc.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;

@Configuration
public class CadastrarMesaConfig {

  @Bean
  public CadastrarMesaUseCase cadastrarMesaUseCase(CadastrarMesaInterface cadastrarMesaInterface) {
    return new CadastrarMesaUseCase((MesaRepository) cadastrarMesaInterface);
  }
}