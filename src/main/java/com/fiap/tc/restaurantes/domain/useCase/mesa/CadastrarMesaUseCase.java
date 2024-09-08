package com.fiap.tc.restaurantes.domain.useCase.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;

public class CadastrarMesaUseCase {

  private final CadastrarMesaInterface cadastrarMesaInterface;

  public CadastrarMesaUseCase(CadastrarMesaInterface cadastrarMesaInterface) {
    this.cadastrarMesaInterface = cadastrarMesaInterface;
  }

  public Mesa cadastrarMesa(Long restauranteId, Mesa mesa) {
    return cadastrarMesaInterface.cadastrarMesa(restauranteId, mesa);
  }
}