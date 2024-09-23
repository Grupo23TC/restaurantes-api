package com.fiap.tc.restaurantes.domain.usecase.reserva;

import com.fiap.tc.restaurantes.domain.gateway.reserva.DeletarReservaInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.fail;

class DeletarReservaUseCaseTest {

    private DeletarReservaUseCase deletarReservaUseCase;

    @Mock
    private DeletarReservaInterface deletarReservaInterface;

    @Mock
    private BuscarReservaPorIdUseCase buscarReservaPorIdUseCase;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        deletarReservaUseCase = new DeletarReservaUseCase(buscarReservaPorIdUseCase, deletarReservaInterface);
    }

    @AfterEach
    void tearDown() throws Exception{
        mock.close();
    }

    @Test
    void devePermitirDeletarReserva() {
        fail("Não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoDeletarReserva_IdNaoEncontrado() {
        fail("Não implementado");
    }
}
