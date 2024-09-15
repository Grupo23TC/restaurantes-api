package com.fiap.tc.restaurantes.domain.useCase.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;
import com.fiap.tc.restaurantes.infra.repository.MesaRepository;

public class CadastrarMesaUseCase {

  private final MesaRepository mesaRepository;

  public CadastrarMesaUseCase(MesaRepository mesaRepository) {
    this.mesaRepository = mesaRepository;
  }

  public Mesa cadastrarMesa(Mesa mesa) {
    return mesaRepository.save(mesa);
  }
}