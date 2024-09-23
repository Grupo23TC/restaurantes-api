package com.fiap.tc.restaurantes.domain.usecase.reserva;


import com.fiap.tc.restaurantes.domain.gateway.reserva.BuscarReservasPorMesaInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.fail;

class BuscarReservasPorMesaUseCaseTest {

    private BuscarReservasPorMesaUseCase buscarReservasPorMesaUseCase;

    @Mock
    private BuscarReservasPorMesaInterface buscarReservasPorMesaInterface;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscarReservasPorMesaUseCase = new BuscarReservasPorMesaUseCase(buscarReservasPorMesaInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirBuscarReservasPorMesa() {
        fail("não implementado.");
    }
}
