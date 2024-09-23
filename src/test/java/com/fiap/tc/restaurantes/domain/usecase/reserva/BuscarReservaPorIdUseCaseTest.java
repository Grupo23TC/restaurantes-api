package com.fiap.tc.restaurantes.domain.usecase.reserva;

import com.fiap.tc.restaurantes.domain.gateway.reserva.BuscarReservaPorIdInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.fail;

class BuscarReservaPorIdUseCaseTest {

    private BuscarReservaPorIdUseCase buscarReservaPorIdUseCase;

    @Mock
    private BuscarReservaPorIdInterface buscarReservaPorIdInterface;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscarReservaPorIdUseCase = new BuscarReservaPorIdUseCase(buscarReservaPorIdInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirBuscarReservaPorId() {
        fail("Não implementado.");
    }

    @Test
    void deveGerarExcecao_QuandoBuscarReservaPorId_IdNaoEncontrado() {
        fail("Não implementado.");
    }
}
