package com.fiap.tc.restaurantes.application.core.usecase.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.in.restaurante.ListarRestauranteInputPort;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.ListarRestauranteOutputPort;

import java.util.List;

public class ListarRestauranteUseCase implements ListarRestauranteInputPort {
  private final ListarRestauranteOutputPort outputPort;

  public ListarRestauranteUseCase(ListarRestauranteOutputPort outputPort) {
    this.outputPort = outputPort;
  }

  @Override
  public List<Restaurante> listarRestaurantes() {
    return outputPort.listarRestaurantes();
  }
}
