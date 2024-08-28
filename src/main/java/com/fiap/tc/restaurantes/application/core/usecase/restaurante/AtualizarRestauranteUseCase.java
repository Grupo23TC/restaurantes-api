package com.fiap.tc.restaurantes.application.core.usecase.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.in.restaurante.AtualizarRestauranteInputPort;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.AtualizarRestauranteOutputPort;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.ConsultarEnderecoPorCepOutputPort;

public class AtualizarRestauranteUseCase implements AtualizarRestauranteInputPort {

  private final AtualizarRestauranteOutputPort atualizarRestauranteOutputPort;

  private final ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort;

  public AtualizarRestauranteUseCase(AtualizarRestauranteOutputPort atualizarRestauranteOutputPort, ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort) {
    this.atualizarRestauranteOutputPort = atualizarRestauranteOutputPort;
    this.consultarEnderecoPorCepOutputPort = consultarEnderecoPorCepOutputPort;
  }

  @Override
  public Restaurante atualizarRestaurante(Long restauranteId, Restaurante restaurante) {
    return atualizarRestauranteOutputPort.atualizarRestaurante(restauranteId, restaurante);
  }
}
