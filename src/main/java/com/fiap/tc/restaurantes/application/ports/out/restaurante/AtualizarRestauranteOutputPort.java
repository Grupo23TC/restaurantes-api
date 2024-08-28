package com.fiap.tc.restaurantes.application.ports.out.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;

public interface AtualizarRestauranteOutputPort {
  Restaurante atualizarRestaurante(Restaurante restaurante);

}
