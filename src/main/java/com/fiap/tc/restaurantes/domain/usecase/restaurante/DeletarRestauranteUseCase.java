package com.fiap.tc.restaurantes.domain.usecase.restaurante;


import com.fiap.tc.restaurantes.domain.gateway.restaurante.DeletarRestauranteInterface;

public class DeletarRestauranteUseCase {
  private final DeletarRestauranteInterface deletarRestauranteInterface;

  public DeletarRestauranteUseCase(DeletarRestauranteInterface deletarRestauranteInterface) {
    this.deletarRestauranteInterface = deletarRestauranteInterface;
  }

  // TODO: Deletar avaliação do restaurante
  public boolean deletarRestaurante(Long id) {
    return deletarRestauranteInterface.deletarRestaurante(id);
  }
}
