package com.fiap.tc.restaurantes.domain.usecase.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.enums.StatusMesaEnum;
import com.fiap.tc.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;
import com.fiap.tc.restaurantes.infra.repository.MesaRepository;

public class CadastrarMesaUseCase {

  private final CadastrarMesaInterface cadastrarMesaInterface;

  public CadastrarMesaUseCase(CadastrarMesaInterface cadastrarMesaInterface) {
    this.cadastrarMesaInterface = cadastrarMesaInterface;
  }

  public Mesa cadastrarMesa(Mesa mesa) {
    mesa.setStatus(StatusMesaEnum.DISPONIVEL);
    return cadastrarMesaInterface.cadastrarMesa(mesa);
  }
}