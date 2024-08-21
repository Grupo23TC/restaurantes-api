package com.fiap.tc.restaurantes.application.ports.in;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;

public interface CadastrarRestauranteInputPort {

    Restaurante cadastrarRestaurante(Restaurante restaurante);

}
