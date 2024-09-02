package com.fiap.tc.restaurantes.application.ports.out.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.core.domain.enumeration.TipoCozinhaEnum;

import java.util.List;

public interface BuscarRestaurantePorTipoCozinhaOutputPort {
  List<Restaurante> buscarPorTipoCozinha(String tipoCozinha);
}
