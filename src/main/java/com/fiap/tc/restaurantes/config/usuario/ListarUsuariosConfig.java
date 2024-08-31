package com.fiap.tc.restaurantes.config.usuario;

import com.fiap.tc.restaurantes.application.core.usecase.usuario.ListarUsuariosUseCase;
import com.fiap.tc.restaurantes.application.ports.out.usuario.ListarUsuariosOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarUsuariosConfig {
  @Bean
  public ListarUsuariosUseCase listarUsuariosUseCase(ListarUsuariosOutputPort listarUsuariosOutputPort) {
    return new ListarUsuariosUseCase(listarUsuariosOutputPort);
  }
}
