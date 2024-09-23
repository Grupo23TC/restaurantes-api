package com.fiap.tc.restaurantes.domain.usecase.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;

public class CadastrarMesaUseCase {

  private final CadastrarMesaInterface cadastrarMesaInterface;

  public CadastrarMesaUseCase(CadastrarMesaInterface cadastrarMesaInterface) {
    this.cadastrarMesaInterface = cadastrarMesaInterface;
  }

  public Mesa cadastrarMesa(Mesa mesa) {
    return cadastrarMesaInterface.cadastrarMesa(mesa);
  }
}