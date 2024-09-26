package com.fiap.tc.restaurantes.domain.usecase.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.entity.validation.restaurante.RestauranteValidator;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.CadastrarRestauranteInterface;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;


public class CadastrarRestauranteUseCase {

    private final CadastrarRestauranteInterface cadastrarRestauranteInterface;

    private final ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface;

    public CadastrarRestauranteUseCase(CadastrarRestauranteInterface cadastrarRestauranteInterface, ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface) {
        this.cadastrarRestauranteInterface = cadastrarRestauranteInterface;
        this.consultarEnderecoPorCepInterface = consultarEnderecoPorCepInterface;
    }

    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        var endereco = consultarEnderecoPorCepInterface.consultaPorCep(restaurante.getEndereco().getCep());
        if (endereco.getCep() == null)
            throw new IllegalArgumentException("CEP inexistente.");

        restaurante.getEndereco().setCidade(endereco.getCidade());
        restaurante.getEndereco().setUf(endereco.getUf());
        restaurante.getEndereco().setBairro(endereco.getBairro());
        restaurante.getEndereco().setLogradouro(endereco.getLogradouro());

        RestauranteValidator.validateRestaurante(restaurante);

        return cadastrarRestauranteInterface.cadastrarRestaurante(restaurante);
    }
}
