package com.fiap.tc.restaurantes.application.ports.in.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.core.domain.enumeration.TipoCozinhaEnum;

import java.util.List;

public interface BuscarRestaurantePorTipoCozinhaInputPort {
  List<Restaurante> buscarPorTipoCozinha(String tipoCozinha);
}
