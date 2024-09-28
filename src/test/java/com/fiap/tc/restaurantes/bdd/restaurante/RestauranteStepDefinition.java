package com.fiap.tc.restaurantes.bdd.restaurante;

import com.fiap.tc.restaurantes.domain.input.restaurante.AtualizarRestauranteRequest;
import com.fiap.tc.restaurantes.domain.input.restaurante.CadastrarRestauranteRequest;
import com.fiap.tc.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestauranteStepDefinition {
  private Response response;
  private RestauranteResponse restauranteResponse;
  private final String ENDPOINT_API_RESTURANTES = "http://localhost:8080/restaurantes";

  @Quando("cadastrar um novo restaurante")
  public RestauranteResponse cadastrar_um_novo_restaurante() {
    CadastrarRestauranteRequest request = RestauranteHelper.gerarCadastrarRestauranteRequest();

    response = given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post(ENDPOINT_API_RESTURANTES);

    return response.then().extract().as(RestauranteResponse.class);
  }

  @Então("o restaurante é registrado com sucesso")
  public void o_restaurante_é_registrado_com_sucesso() {
    response.then()
        .statusCode(HttpStatus.CREATED.value());
  }

  @Então("o restaurante deve ser apresentado")
  public void o_restaurante_deve_ser_apresentado() {
    response.then()
        .body(matchesJsonSchemaInClasspath("schemas/restaurante/restaurante.schema.json"));
  }

  @Dado("que um restaurante já está cadastrado")
  public void que_um_restaurante_já_está_cadastrado() {
    restauranteResponse = cadastrar_um_novo_restaurante();
  }

  @Quando("efetuar a busca de restaurante")
  public void efetuar_a_busca_de_restaurante() {
    response = when()
        .get(ENDPOINT_API_RESTURANTES + "/{id}", restauranteResponse.restauranteId());
  }

  @Então("o restaurante é exibido com sucesso")
  public void o_restaurante_é_exibido_com_sucesso() {
    response.then()
        .body(matchesJsonSchemaInClasspath("schemas/restaurante/restaurante.schema.json"));
  }

  @Então("efeturar a requisição para atualizar o restaurante")
  public void efeturar_a_requisição_para_atualizar_o_restaurante() {
    AtualizarRestauranteRequest request = RestauranteHelper.gerarAtualizarRestauranteRequest();

    response =
        given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .put(ENDPOINT_API_RESTURANTES + "/{id}", restauranteResponse.restauranteId());
  }

  @Então("o restaurante é atualizado com sucesso")
  public void o_restaurante_é_atualizado_com_sucesso() {
    response.then()
        .statusCode(HttpStatus.OK.value());
  }

  @Quando("requisitar a remoção do restaurante")
  public void requisitar_a_remoção_do_restaurante() {
    response = when()
        .delete(ENDPOINT_API_RESTURANTES + "/{id}", restauranteResponse.restauranteId());
  }

  @Então("o restaurante é removido com sucesso")
  public void o_restaurante_é_removido_com_sucesso() {
    response.then()
        .statusCode(HttpStatus.OK.value());
  }

  @Então("deve apresentar o resultado da remoção do restaurante")
  public void deve_apresentar_o_resultado_da_remoção_do_restaurante() {
    response.then()
        .body(matchesJsonSchemaInClasspath("schemas/restaurante/restauranteDeletadoResponse.schema.json"));
  }

}
