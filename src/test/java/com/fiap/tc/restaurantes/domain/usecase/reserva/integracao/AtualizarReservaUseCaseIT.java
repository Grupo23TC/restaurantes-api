package com.fiap.tc.restaurantes.domain.usecase.reserva.integracao;

import com.fiap.tc.restaurantes.domain.usecase.reserva.AtualizarReservaUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class AtualizarReservaUseCaseIT {

    @Autowired
    private AtualizarReservaUseCase atualizarReservaUseCase;

    @Test
    void devePermitirAtualizarReserva() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoAtualizarReserva_IdNaoEncontrado() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoAtualizarReserva_DataInicioAntesDeHoje() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoAtualizarReserva_DataFimAntesDeHoje() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoAtualizarReserva_DataInicioMaiorQueDataFim() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoAtualizarReserva_MesaJaReservada() {
        fail("não implementado");
    }
}
