package com.fiap.tc.restaurantes.application.ports.out;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;

public interface CadastrarRestauranteOutputPort {

    Restaurante cadastrarRestaurante(Restaurante restaurante);

}
