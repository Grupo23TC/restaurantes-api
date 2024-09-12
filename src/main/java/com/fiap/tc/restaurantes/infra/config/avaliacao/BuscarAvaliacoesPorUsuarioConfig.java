package com.fiap.tc.restaurantes.infra.config.avaliacao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorUsuarioInterface;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarAvaliacoesPorUsuarioConfig {

    @Bean
    BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase(BuscarAvaliacoesPorUsuarioInterface buscarAvaliacoesPorUsuarioInterface) {
        return new BuscarAvaliacoesPorUsuarioUseCase(buscarAvaliacoesPorUsuarioInterface);
    }
}
