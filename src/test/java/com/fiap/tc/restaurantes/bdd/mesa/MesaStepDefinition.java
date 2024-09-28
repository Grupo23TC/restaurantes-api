package com.fiap.tc.restaurantes.bdd.mesa;

import com.fiap.tc.restaurantes.domain.input.mesa.CadastrarMesaRequest;

import com.fiap.tc.restaurantes.domain.input.restaurante.CadastrarRestauranteRequest;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.tc.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.tc.restaurantes.utils.mesa.MesaHelper;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class MesaStepDefinition {
  private Response response;
  private MesaResponse mesaResponse;
  private RestauranteResponse restauranteResponse;
  private final String ENDPOINT_API_MENSAGENS = "http://localhost:8080/mesas";

  @Dado("que um restaurante já está cadastrado")
  public void que_um_restaurante_já_está_cadastrado() {
    CadastrarRestauranteRequest request = RestauranteHelper.gerarCadastrarRestauranteRequest();

    response = given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post(ENDPOINT_API_MENSAGENS);

    restauranteResponse = response.as(RestauranteResponse.class);
  }

  @Quando("cadastrar uma mesa para o restaurante")
  public MesaResponse cadastrar_uma_mesa_para_o_restaurante() {
    CadastrarMesaRequest request = MesaHelper.gerarMesaCadastroRequest(1L, 8);

    response = given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post(ENDPOINT_API_MENSAGENS);

    return response.then().extract().as(MesaResponse.class);
  }

  @Então("a mesa é registrada com sucesso")
  public void a_mesa_é_registrada_com_sucesso() {
    response.then()
        .statusCode(HttpStatus.CREATED.value());
  }

  @Então("a mesa deve ser apresentada")
  public void a_mesa_deve_ser_apresentada() {
    response.then()
        .body(matchesJsonSchemaInClasspath("schemas/mesa/mesa.schema.json"));
  }
}
