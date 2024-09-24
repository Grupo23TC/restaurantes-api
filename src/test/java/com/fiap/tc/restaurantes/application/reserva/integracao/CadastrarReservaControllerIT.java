package com.fiap.tc.restaurantes.application.reserva.integracao;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.fail;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class CadastrarReservaControllerIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void devePermitirCadastrarReserva() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_UsuarioNaoEncontrado() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_MesaNaoEncontrada() {
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
