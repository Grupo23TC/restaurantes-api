package com.fiap.tc.restaurantes.domain.gateway.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Endereco;

public interface ConsultarEnderecoPorCepInterface {

    /**
     * @param cep
     * @return
     */
    Endereco consultaPorCep(final String cep);

}
