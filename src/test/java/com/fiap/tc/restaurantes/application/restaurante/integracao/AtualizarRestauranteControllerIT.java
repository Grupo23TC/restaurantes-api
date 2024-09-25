package com.fiap.tc.restaurantes.application.restaurante.integracao;

import com.fiap.tc.restaurantes.domain.input.restaurante.AtualizarRestauranteRequest;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
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
public class AtualizarRestauranteControllerIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void deveAtualizarRestaurante() {
        AtualizarRestauranteRequest restauranteRequest = RestauranteHelper.gerarAtualizarRestauranteRequest();
        Long id = 2L;

        given()
                .contentType("application/json")
                .body(restauranteRequest)
                .log().all()
                .when()
                .put("/restaurantes/{id}", id)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(matchesJsonSchemaInClasspath("schemas/restaurante/restaurante.schema.json"))
                .log().all();
    }
}
