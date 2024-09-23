package com.fiap.tc.restaurantes.domain.usecase.reserva;

import com.fiap.tc.restaurantes.domain.gateway.reserva.BuscarReservasPorMesaInterface;
import com.fiap.tc.restaurantes.domain.gateway.reserva.BuscarReservasPorUsuarioInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.fail;

class BuscarReservasPorUsuarioUseCaseTest {

    private BuscarReservasPorUsuarioUseCase buscarReservasPorUsuarioUseCase;

    @Mock
    private BuscarReservasPorUsuarioInterface buscarReservasPorUsuarioInterface;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscarReservasPorUsuarioUseCase = new BuscarReservasPorUsuarioUseCase(buscarReservasPorUsuarioInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirBuscarReservasPorUsuario() {
        fail("não implementado.");
    }
}
