package com.fiap.tc.restaurantes.domain.usecase.reserva.integracao;

import com.fiap.tc.restaurantes.domain.usecase.reserva.BuscarReservasPorUsuarioUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class BuscarReservasPorUsuarioUseCaseIT {

    @Autowired
    private BuscarReservasPorUsuarioUseCase buscarReservasPorUsuarioUseCase;

    @Test
    void devePermitirBuscarReservasPorUsuario() {
        fail("não implementado.");
    }
}
