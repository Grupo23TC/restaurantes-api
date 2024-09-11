package com.fiap.tc.restaurantes.infra.config.restaurante;

import com.fiap.tc.restaurantes.domain.useCase.restaurante.CadastrarRestauranteUseCase;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.CadastrarRestauranteInterface;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarRestauranteConfig {

    /**
     * @param cadastrarRestauranteInterface
     * @param consultarEnderecoPorCepInterface
     * @return
     */
    @Bean
    public CadastrarRestauranteUseCase cadastrarRestauranteUseCase(CadastrarRestauranteInterface cadastrarRestauranteInterface,
                                                                   ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface) {
        return new CadastrarRestauranteUseCase(cadastrarRestauranteInterface, consultarEnderecoPorCepInterface);
    }
}
