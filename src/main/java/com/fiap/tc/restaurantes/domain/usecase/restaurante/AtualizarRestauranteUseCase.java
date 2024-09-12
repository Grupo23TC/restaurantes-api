package com.fiap.tc.restaurantes.domain.useCase.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.AtualizarRestauranteInterface;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;

public class AtualizarRestauranteUseCase {

  private final AtualizarRestauranteInterface atualizarRestauranteInterface;
  private final ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface;

  public AtualizarRestauranteUseCase(AtualizarRestauranteInterface atualizarRestauranteInterface, ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface) {
    this.atualizarRestauranteInterface = atualizarRestauranteInterface;
    this.consultarEnderecoPorCepInterface = consultarEnderecoPorCepInterface;
  }


  public Restaurante atualizarRestaurante(Long restauranteId, Restaurante restaurante) {
    return atualizarRestauranteInterface.atualizarRestaurante(restauranteId, restaurante);
  }
}
