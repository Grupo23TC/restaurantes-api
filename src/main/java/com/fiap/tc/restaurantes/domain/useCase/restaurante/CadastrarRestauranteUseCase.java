package com.fiap.tc.restaurantes.domain.useCase.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.CadastrarRestauranteInterface;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;


public class CadastrarRestauranteUseCase {

    private final CadastrarRestauranteInterface cadastrarRestauranteInterface;

    private final ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface;

    public CadastrarRestauranteUseCase(CadastrarRestauranteInterface cadastrarRestauranteInterface, ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface) {
        this.cadastrarRestauranteInterface = cadastrarRestauranteInterface;
        this.consultarEnderecoPorCepInterface = consultarEnderecoPorCepInterface;
    }

    // TODO Rever como podemos utilizar melhor essa API de consulta de CEP
    // Talvez podemos passar apenas o cep no request e popular o endereco a partir disso?
    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        var endereco = consultarEnderecoPorCepInterface.consultaPorCep(restaurante.getEndereco().getCep());
        if (endereco == null)
            throw new IllegalArgumentException("CEP inexistente.");

        restaurante.getEndereco().setCidade(endereco.getCidade());
        restaurante.getEndereco().setUf(endereco.getUf());

        return cadastrarRestauranteInterface.cadastrarRestaurante(restaurante);
    }
}
