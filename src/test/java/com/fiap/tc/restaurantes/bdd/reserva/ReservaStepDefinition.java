package com.fiap.tc.restaurantes.bdd.reserva;

import com.fiap.tc.restaurantes.bdd.mesa.MesaStepDefinition;
import com.fiap.tc.restaurantes.domain.output.reserva.ReservaResponse;
import com.fiap.tc.restaurantes.utils.reserva.ReservaHelper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ReservaStepDefinition {

    private Response response;
    private ReservaResponse reservaResponse;
    private final String ENDPOINT_API_RESERVAS = "http://localhost:8080/reservas";

    @Quando("cadastrar uma reserva")
    public ReservaResponse cadastrar_uma_reserva() {
        var request = ReservaHelper.gerarCadastrarReservaRequest();

        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post(ENDPOINT_API_RESERVAS);

        return response.then().extract().as(ReservaResponse.class);
    }

    @Então("a reserva é registrada com sucesso")
    public void a_reserva_é_registrada_com_sucesso() {
        response.then()
                .statusCode(HttpStatus.OK.value());
    }

    @Então("a reserva deve ser apresentada")
    public void a_reserva_deve_ser_apresentada() {
        response.then()
                .body(matchesJsonSchemaInClasspath("schemas/reserva/reservaResponse.schema.json"));
    }

    @Dado("que a reserva já está cadastrada")
    public void que_a_reserva_já_está_cadastrada() {
        reservaResponse = cadastrar_uma_reserva();
    }

    @Quando("efetuar a busca da reserva")
    public void efetuar_a_busca_da_reserva() {
        response = when()
                .get(ENDPOINT_API_RESERVAS + "/{id}", reservaResponse.reservaId());
    }

    @Então("efeturar a requisição para atualizar a reserva")
    public void efeturar_a_requisição_para_atualizar_a_reserva() {
        var request = ReservaHelper.gerarAtualizarReservaRequest();

        response =
                given()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .body(request)
                        .when()
                        .put(ENDPOINT_API_RESERVAS + "/{id}", reservaResponse.reservaId());
    }

    @Então("a reserva é atualizada com sucesso")
    public void a_reserva_é_atualizada_com_sucesso() {
        response.then()
                .statusCode(HttpStatus.OK.value());
    }

    @Quando("requisitar a remoção da reserva")
    public void requisitar_a_remoção_da_reserva() {
        response = when()
                .delete(ENDPOINT_API_RESERVAS + "/{id}", reservaResponse.reservaId());
    }

    @Então("a reserva é removida com sucesso")
    public void a_reserva_é_removida_com_sucesso() {
        response.then()
                .statusCode(HttpStatus.OK.value());
    }

    @Então("deve apresentar o resultado da remoção de reserva")
    public void deve_apresentar_o_resultado_da_remoção_de_reserva() {
        response.then()
                .body(matchesJsonSchemaInClasspath("schemas/reserva/reservaDeletada.schema.json"));
    }

    @Dado("que a mesa já está cadastrada")
    public void que_a_mesa_já_está_cadastrada() {
        MesaStepDefinition mesaStepDefinition = new MesaStepDefinition();
        mesaStepDefinition.que_a_mesa_já_está_cadastrada();
    }

}
