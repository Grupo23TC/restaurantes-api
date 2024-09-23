package com.fiap.tc.restaurantes.domain.usecase.reserva;

import com.fiap.tc.restaurantes.domain.gateway.reserva.BuscarReservasPorMesaEPeriodoInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.fail;

class BuscarReservasPorMesaEPeriodoUseCaseTest {

    private BuscarReservasPorMesaEPeriodoUseCase buscarReservasPorMesaEPeriodoUseCase;

    @Mock
    private BuscarReservasPorMesaEPeriodoInterface buscarReservasPorMesaEPeriodoInterface;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscarReservasPorMesaEPeriodoUseCase = new BuscarReservasPorMesaEPeriodoUseCase(buscarReservasPorMesaEPeriodoInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirBuscarReservasPorMesaEPeriodo() {
        fail("não implementado.");
    }
}

