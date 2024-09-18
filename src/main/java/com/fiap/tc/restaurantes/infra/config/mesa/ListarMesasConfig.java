package com.fiap.tc.restaurantes.infra.config.mesa;

import com.fiap.tc.restaurantes.domain.usecase.mesa.ListarMesasPorRestauranteUseCase;
import com.fiap.tc.restaurantes.domain.gateway.mesa.ListarMesasPorRestauranteInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarMesasConfig {
    @Bean
    public ListarMesasPorRestauranteUseCase listarMesasUseCase(ListarMesasPorRestauranteInterface listarMesasPorRestauranteInterface) {
        return new ListarMesasPorRestauranteUseCase(listarMesasPorRestauranteInterface);
    }
}