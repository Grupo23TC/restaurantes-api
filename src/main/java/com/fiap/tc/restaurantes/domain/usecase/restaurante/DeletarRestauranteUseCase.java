package com.fiap.tc.restaurantes.domain.usecase.restaurante;


import com.fiap.tc.restaurantes.domain.gateway.restaurante.DeletarRestauranteInterface;

public class DeletarRestauranteUseCase {
  private final DeletarRestauranteInterface deletarRestauranteInterface;

  public DeletarRestauranteUseCase(DeletarRestauranteInterface deletarRestauranteInterface) {
    this.deletarRestauranteInterface = deletarRestauranteInterface;
  }

  public boolean deletarRestaurante(Long id) {
    return deletarRestauranteInterface.deletarRestaurante(id);
  }
}
