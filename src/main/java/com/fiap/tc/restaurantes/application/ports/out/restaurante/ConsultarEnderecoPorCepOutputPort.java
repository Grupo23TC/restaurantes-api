package com.fiap.tc.restaurantes.application.ports.out.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Endereco;

public interface ConsultarEnderecoPorCepOutputPort {

    /**
     * @param cep
     * @return
     */
    Endereco consultaPorCep(final String cep);

}
