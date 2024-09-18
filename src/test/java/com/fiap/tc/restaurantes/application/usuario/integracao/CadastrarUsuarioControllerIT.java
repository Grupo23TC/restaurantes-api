package com.fiap.tc.restaurantes.application.usuario.integracao;

import com.fiap.tc.restaurantes.domain.input.usuario.CadastrarUsuarioRequest;
import com.fiap.tc.restaurantes.utils.usuario.UsuarioHelper;
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
public class CadastrarUsuarioControllerIT {
  @LocalServerPort
  private int port;

  @BeforeEach
  public void setUp() {
    RestAssured.port = port;
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

  @Test
  void deveCadastrarUsuario() {
    CadastrarUsuarioRequest usuario = UsuarioHelper.gerarCadastrarUsuarioRequest();

    given()
        .contentType("application/json")
        .body(usuario)
        .log().all()
    .when()
        .post("/usuarios")
    .then()
        .statusCode(HttpStatus.CREATED.value())
        .body(matchesJsonSchemaInClasspath("schemas/usuario/cadastrarUsuarioRequest.schema.json"))
        .log().all();
  }
}
