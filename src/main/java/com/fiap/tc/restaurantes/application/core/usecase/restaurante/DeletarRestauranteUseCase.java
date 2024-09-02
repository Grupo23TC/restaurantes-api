package com.fiap.tc.restaurantes.application.core.usecase.restaurante;

import com.fiap.tc.restaurantes.application.ports.in.restaurante.DeletarRestauranteInputPort;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.DeletarRestauranteOutputPort;

public class DeletarRestauranteUseCase implements DeletarRestauranteInputPort {
  private final DeletarRestauranteOutputPort outputPort;

  public DeletarRestauranteUseCase(DeletarRestauranteOutputPort outputPort) {
    this.outputPort = outputPort;
  }

  @Override
  public boolean deletarRestaurante(Long id) {
    return outputPort.deletarRestaurante(id);
  }
}
