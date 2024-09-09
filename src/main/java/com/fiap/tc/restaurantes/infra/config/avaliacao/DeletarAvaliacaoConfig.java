package com.fiap.tc.restaurantes.infra.config.avaliacao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.DeletarAvaliacaoInterface;
import com.fiap.tc.restaurantes.domain.useCase.avaliacao.BuscarAvaliacaoPorIdUseCase;
import com.fiap.tc.restaurantes.domain.useCase.avaliacao.DeletarAvaliacaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarAvaliacaoConfig {

    @Bean
    DeletarAvaliacaoUseCase deletarAvaliacaoUseCase(DeletarAvaliacaoInterface deletarAvaliacaoInterface,
                                                    BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase) {
        return new DeletarAvaliacaoUseCase(deletarAvaliacaoInterface, buscarAvaliacaoPorIdUseCase);
    }
}
