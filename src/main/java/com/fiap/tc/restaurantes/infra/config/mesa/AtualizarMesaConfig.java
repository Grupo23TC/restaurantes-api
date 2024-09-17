package com.fiap.tc.restaurantes.infra.config.mesa;

import com.fiap.tc.restaurantes.domain.usecase.mesa.AtualizarMesaUseCase;
import com.fiap.tc.restaurantes.domain.gateway.mesa.AtualizarMesaInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarMesaConfig {
    @Bean
    public AtualizarMesaUseCase atualizarMesaUseCase(AtualizarMesaInterface atualizarMesaInterface) {
        return new AtualizarMesaUseCase(atualizarMesaInterface);
    }
}