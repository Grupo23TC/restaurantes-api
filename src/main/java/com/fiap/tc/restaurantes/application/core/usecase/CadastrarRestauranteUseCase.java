package com.fiap.tc.restaurantes.application.core.usecase;

import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.in.CadastrarRestauranteInputPort;
import com.fiap.tc.restaurantes.application.ports.out.CadastrarRestauranteOutputPort;
import com.fiap.tc.restaurantes.application.ports.out.ConsultarEnderecoPorCepOutputPort;


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
        var endereco = consultarEnderecoPorCepOutputPort.consultaPorCep(restaurante.getLocalizacao().getCep());
        if (endereco == null)
            throw new IllegalArgumentException("CEP inexistente.");

        restaurante.getLocalizacao().setCidade(endereco.getCidade());
        restaurante.getLocalizacao().setUf(endereco.getUf());

        return cadastrarRestauranteOutputPort.cadastrarRestaurante(restaurante);
    }
}
