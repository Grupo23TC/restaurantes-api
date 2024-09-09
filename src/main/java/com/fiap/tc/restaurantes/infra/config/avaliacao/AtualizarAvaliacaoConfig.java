package com.fiap.tc.restaurantes.infra.config.avaliacao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.AtualizarAvaliacaoInterface;
import com.fiap.tc.restaurantes.domain.useCase.avaliacao.AtualizarAvaliacaoUseCase;
import com.fiap.tc.restaurantes.domain.useCase.avaliacao.BuscarAvaliacaoPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarAvaliacaoConfig {

    @Bean
    AtualizarAvaliacaoUseCase atualizarAvaliacaoUseCase(AtualizarAvaliacaoInterface atualizarAvaliacaoInterface,
                                                        BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase) {

        return new AtualizarAvaliacaoUseCase(atualizarAvaliacaoInterface, buscarAvaliacaoPorIdUseCase);
    }
}
