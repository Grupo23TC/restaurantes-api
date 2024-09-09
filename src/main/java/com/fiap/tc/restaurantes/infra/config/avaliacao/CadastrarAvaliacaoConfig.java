package com.fiap.tc.restaurantes.infra.config.avaliacao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.CadastrarAvaliacaoInterface;
import com.fiap.tc.restaurantes.domain.useCase.avaliacao.CadastrarAvaliacaoUseCase;
import com.fiap.tc.restaurantes.domain.useCase.restaurante.BuscarRestaurantePorIdUseCase;
import com.fiap.tc.restaurantes.domain.useCase.usuario.BuscarUsuarioPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarAvaliacaoConfig {

    @Bean
    CadastrarAvaliacaoUseCase cadastrarAvaliacaoUseCase(CadastrarAvaliacaoInterface cadastrarAvaliacaoInterface,
                                                        BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase,
                                                        BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase) {
        return new CadastrarAvaliacaoUseCase(cadastrarAvaliacaoInterface, buscarUsuarioPorIdUseCase, buscarRestaurantePorIdUseCase);
    }
}
