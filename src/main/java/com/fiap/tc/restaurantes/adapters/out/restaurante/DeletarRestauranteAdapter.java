package com.fiap.tc.restaurantes.adapters.out.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.DeletarRestauranteOutputPort;

public class DeletarRestauranteAdapter implements DeletarRestauranteOutputPort {
  @Override
  public boolean deletarRestaurante(Restaurante restaurante) {
    return false;
  }
}
