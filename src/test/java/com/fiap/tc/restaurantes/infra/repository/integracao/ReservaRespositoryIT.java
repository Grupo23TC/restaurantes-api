package com.fiap.tc.restaurantes.infra.repository.integracao;

import com.fiap.tc.restaurantes.infra.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class ReservaRespositoryIT {

    @Autowired
    private ReservaRepository reservaRepository;

    @Test
    void devePermitirCriarTabela() {
        var totalDeRegistros = reservaRepository.count();
        assertThat(totalDeRegistros).isPositive();
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
