package com.fiap.tc.restaurantes.application.avaliacao.integracao;


import io.restassured.RestAssured;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class BuscarAvaliacaoPorIdControllerIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void devePermitirBuscarAvaliacaoPorId() {
        var id = 1L;

        given()
                .log().all()
        .when()
                .get("/avaliacoes/{id}", id)
        .then()
                .statusCode(HttpStatus.OK.value())
                .body(matchesJsonSchemaInClasspath("schemas/avaliacao/avaliacaoResponse.schema.json"))
                .log().all();
    }

    @Test
    void deveGerarExcecao_QuandoBuscarAvaliacaoPorId_IdNaoEncontrado() {
        var id = 1502825L;

        given()
                .log().all()
        .when()
                .get("/avaliacoes/{id}", id)
        .then()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .body(matchesJsonSchemaInClasspath("schemas/exception/erroCustomizado.schema.json"))
                .log().all();
    }
}
