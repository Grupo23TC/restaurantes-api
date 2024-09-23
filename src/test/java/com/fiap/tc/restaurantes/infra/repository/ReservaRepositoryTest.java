package com.fiap.tc.restaurantes.infra.repository;

import com.fiap.tc.restaurantes.infra.entity.ReservaEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ReservaRepositoryTest {

    @Mock
    private ReservaRepository reservaRepository;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Nested
    class CadastrarReserva {

        @Test
        void devePermitirCadastrarReserva() {
            fail("Não implementado.");
        }

    }

    @Nested
    class BuscarReserva {

        @Test
        void devePermitirBuscarReservaPorId() {
            fail("Não implementado.");
        }

        @Test
        void devePermitirBuscarReservasPorMesa() {
            fail("Não implementado.");
        }

        @Test
        void devePermitirBuscarReservasPorMesaEPeriodo() {
            fail("Não implementado.");
        }

        @Test
        void devePermitirBuscarReservasPorUsuario() {
            fail("Não implementado.");
        }

    }

    @Nested
    class DeletarReserva {

        @Test
        void devePermitirDeletarReserva() {
            fail("Não implementado.");
        }

    }

}
