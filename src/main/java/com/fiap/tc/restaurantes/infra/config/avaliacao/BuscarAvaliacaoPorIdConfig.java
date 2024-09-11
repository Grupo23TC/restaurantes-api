package com.fiap.tc.restaurantes.infra.config.avaliacao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacaoPorIdInterface;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.BuscarAvaliacaoPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarAvaliacaoPorIdConfig {

    @Bean
    BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase(BuscarAvaliacaoPorIdInterface buscarAvaliacaoPorIdInterface) {
        return new BuscarAvaliacaoPorIdUseCase(buscarAvaliacaoPorIdInterface);
    }
}
