package com.fiap.tc.restaurantes.application.restaurante.integracao;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.when;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class BuscarRestaurantePorTipoCozinhaControllerIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void deveBuscarRestaurantePorTipoCozinha() {
        when()
                .get("/restaurantes?tipoCozinha=MEXICANA")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value());
//                .body(matchesJsonSchemaInClasspath("schemas/usuario/usuario.schema.json"));
    }
}
