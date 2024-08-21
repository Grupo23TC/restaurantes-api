package com.fiap.tc.restaurantes.config.restaurante;

import com.fiap.tc.restaurantes.application.core.usecase.CadastrarRestauranteUseCase;
import com.fiap.tc.restaurantes.application.ports.out.CadastrarRestauranteOutputPort;
import com.fiap.tc.restaurantes.application.ports.out.ConsultarEnderecoPorCepOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarRestauranteConfig {

    /**
     * @param cadastrarRestauranteOutputPort
     * @param consultarEnderecoPorCepOutputPort
     * @return
     */
    @Bean
    public CadastrarRestauranteUseCase cadastrarRestauranteUseCase(CadastrarRestauranteOutputPort cadastrarRestauranteOutputPort,
                                                                   ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort) {
        return new CadastrarRestauranteUseCase(cadastrarRestauranteOutputPort, consultarEnderecoPorCepOutputPort);
    }
}
