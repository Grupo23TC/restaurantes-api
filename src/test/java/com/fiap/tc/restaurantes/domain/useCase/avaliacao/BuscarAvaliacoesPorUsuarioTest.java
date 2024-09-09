package com.fiap.tc.restaurantes.domain.useCase.avaliacao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorUsuarioInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.fail;

public class BuscarAvaliacoesPorUsuarioTest {

    private BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase;

    @Mock
    private BuscarAvaliacoesPorUsuarioInterface buscarAvaliacoesPorUsuarioInterface;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscarAvaliacoesPorUsuarioUseCase = new BuscarAvaliacoesPorUsuarioUseCase(buscarAvaliacoesPorUsuarioInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirBuscarAvaliacoesPorUsuario() {
        fail("Não implementado");
    }
}
