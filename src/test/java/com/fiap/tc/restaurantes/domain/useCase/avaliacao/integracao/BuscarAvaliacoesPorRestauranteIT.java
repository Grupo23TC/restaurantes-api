package com.fiap.tc.restaurantes.domain.useCase.avaliacao.integracao;

import com.fiap.tc.restaurantes.domain.useCase.avaliacao.BuscarAvaliacoesPorRestauranteUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.fail;
@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class BuscarAvaliacoesPorRestauranteIT {

    @Autowired
    private BuscarAvaliacoesPorRestauranteUseCase buscarAvaliacoesPorRestauranteUseCase;

    @Test
    void devePermitirBuscarAvaliacoesPorRestaurante() {
        fail("Não implementado");
    }
}
