package com.fiap.tc.restaurantes.application.core.usecase.restaurante;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.in.restaurante.CadastrarRestauranteInputPort;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.CadastrarRestauranteOutputPort;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.ConsultarEnderecoPorCepOutputPort;


public class CadastrarRestauranteUseCase implements CadastrarRestauranteInputPort {

    private final CadastrarRestauranteOutputPort cadastrarRestauranteOutputPort;

    private final ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort;

    public CadastrarRestauranteUseCase(CadastrarRestauranteOutputPort cadastrarRestauranteOutputPort, ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort) {
        this.cadastrarRestauranteOutputPort = cadastrarRestauranteOutputPort;
        this.consultarEnderecoPorCepOutputPort = consultarEnderecoPorCepOutputPort;
    }

    // TODO Rever como podemos utilizar melhor essa API de consulta de CEP
    // Talvez podemos passar apenas o cep no request e popular o endereco a partir disso?
    @Override
    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        var endereco = consultarEnderecoPorCepOutputPort.consultaPorCep(restaurante.getEndereco().getCep());
        if (endereco == null)
            throw new IllegalArgumentException("CEP inexistente.");

        restaurante.getEndereco().setCidade(endereco.getCidade());
        restaurante.getEndereco().setUf(endereco.getUf());

        return cadastrarRestauranteOutputPort.cadastrarRestaurante(restaurante);
    }
}
