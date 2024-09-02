package com.fiap.tc.restaurantes.application.ports.in.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;

import java.util.List;

public interface ListarRestauranteInputPort {
  List<Restaurante> listarRestaurantes();
}
