package com.fiap.tc.restaurantes.infra.config.mesa;

import com.fiap.tc.restaurantes.domain.usecase.mesa.ListarMesasUseCase;
import com.fiap.tc.restaurantes.domain.gateway.mesa.ListarMesasInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarMesasConfig {
    @Bean
    public ListarMesasUseCase listarMesasUseCase(ListarMesasInterface listarMesasInterface) {
        return new ListarMesasUseCase(listarMesasInterface);
    }
}