package com.fiap.tc.restaurantes.infra.config.usuario;

import com.fiap.tc.restaurantes.domain.usecase.usuario.ListarUsuariosUseCase;
import com.fiap.tc.restaurantes.domain.gateway.usuario.ListarUsuariosInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarUsuariosConfig {
  @Bean
  public ListarUsuariosUseCase listarUsuariosUseCase(ListarUsuariosInterface listarUsuariosInterface) {
    return new ListarUsuariosUseCase(listarUsuariosInterface);
  }
}
