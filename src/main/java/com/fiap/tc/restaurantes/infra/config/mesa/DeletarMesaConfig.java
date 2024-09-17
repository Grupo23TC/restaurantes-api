package com.fiap.tc.restaurantes.infra.config.mesa;

import com.fiap.tc.restaurantes.domain.usecase.mesa.DeletarMesaUseCase;
import com.fiap.tc.restaurantes.domain.gateway.mesa.DeletarMesaInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarMesaConfig {
    @Bean
    public DeletarMesaUseCase deletarMesaUseCase(DeletarMesaInterface deletarMesaInterface) {
        return new DeletarMesaUseCase(deletarMesaInterface);
    }
}