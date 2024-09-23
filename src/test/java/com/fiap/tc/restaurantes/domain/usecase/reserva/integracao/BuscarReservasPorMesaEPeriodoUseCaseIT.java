package com.fiap.tc.restaurantes.domain.usecase.reserva.integracao;

import com.fiap.tc.restaurantes.domain.usecase.reserva.BuscarReservasPorMesaEPeriodoUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class BuscarReservasPorMesaEPeriodoUseCaseIT {

    @Autowired
    private BuscarReservasPorMesaEPeriodoUseCase buscarReservasPorMesaEPeriodoUseCase;

    @Test
    void devePermitirBuscarReservasPorMesaEPeriodo() {
        fail("não implementado.");
    }
}
