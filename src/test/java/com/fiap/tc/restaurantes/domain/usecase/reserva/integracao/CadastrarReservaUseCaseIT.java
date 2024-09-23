package com.fiap.tc.restaurantes.domain.usecase.reserva.integracao;

import com.fiap.tc.restaurantes.domain.usecase.reserva.CadastrarReservaUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class CadastrarReservaUseCaseIT {

    @Autowired
    private CadastrarReservaUseCase cadastrarReservaUseCase;

    @Test
    void devePermitirCadastrarReserva() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_IdNaoEncontrado() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_DataInicioAntesDeHoje() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_DataFimAntesDeHoje() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_DataInicioMaiorQueDataFim() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_MesaJaReservada() {
        fail("não implementado");
    }
}
