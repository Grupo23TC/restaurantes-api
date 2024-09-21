package com.fiap.tc.restaurantes.infra.config.usuario;

import com.fiap.tc.restaurantes.domain.gateway.usuario.BuscarUsuarioPorIdInterface;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorUsuarioUseCase;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.DeletarAvaliacaoUseCase;
import com.fiap.tc.restaurantes.domain.usecase.usuario.BuscarUsuarioPorIdUseCase;
import com.fiap.tc.restaurantes.domain.usecase.usuario.DeletarUsuarioUseCase;
import com.fiap.tc.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarUsuarioConfig {
  @Bean
  public DeletarUsuarioUseCase deletarUsuarioUseCase(
      DeletarUsuarioInterface deletarUsuarioInterface,
      BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase,
      BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase,
      DeletarAvaliacaoUseCase deletarAvaliacaoUseCase
  ) {
    return new DeletarUsuarioUseCase(
        deletarUsuarioInterface,
        buscarUsuarioPorIdUseCase,
        buscarAvaliacoesPorUsuarioUseCase,
        deletarAvaliacaoUseCase
    );
  }
}
