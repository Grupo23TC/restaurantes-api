package com.fiap.tc.restaurantes.application.usuario.integracao;

import com.fiap.tc.restaurantes.domain.input.usuario.AtualizarUsuarioRequest;
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
public class AtualizarUsuarioControllerIT {
  @LocalServerPort
  private int port;

  @BeforeEach
  public void setUp() {
    RestAssured.port = port;
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

  @Test
  void deveAtualizarUsuario() {
    AtualizarUsuarioRequest usuario = UsuarioHelper.gerarAtualizarUsuarioRequest();
    Long id = 4L;

    given()
        .contentType("application/json")
        .body(usuario)
        .log().all()
    .when()
        .put("/usuarios/{id}", id)
    .then()
        .statusCode(HttpStatus.OK.value())
        .body(matchesJsonSchemaInClasspath("schemas/usuario/usuario.schema.json"))
        .log().all();

  }

  @Test
  void deveGerarExcecao_QuandoAtualizaUsuario_IdNaoExiste() {
    AtualizarUsuarioRequest usuario = UsuarioHelper.gerarAtualizarUsuarioRequest();
    Long id = 300L;

    given()
        .contentType("application/json")
        .body(usuario)
        .log().all()
    .when()
        .put("/usuarios/{id}", id)
    .then()
        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .log().all();
  }
}
