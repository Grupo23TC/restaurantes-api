package com.fiap.tc.restaurantes.domain.useCase.avaliacao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorRestauranteInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.fail;

public class BuscarAvaliacoesPorRestauranteTest {

    private BuscarAvaliacoesPorRestauranteUseCase buscarAvaliacoesPorRestauranteUseCase;

    @Mock
    private BuscarAvaliacoesPorRestauranteInterface buscarAvaliacoesPorRestauranteInterface;

    AutoCloseable mock;

    @BeforeEach
    public void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscarAvaliacoesPorRestauranteUseCase = new BuscarAvaliacoesPorRestauranteUseCase(buscarAvaliacoesPorRestauranteInterface);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirBuscarAvaliacoesPorRestaurante() {
        fail("Não implementado");
    }
}
