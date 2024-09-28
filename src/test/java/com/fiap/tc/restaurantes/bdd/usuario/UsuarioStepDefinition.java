package com.fiap.tc.restaurantes.bdd.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.input.usuario.AtualizarUsuarioRequest;
import com.fiap.tc.restaurantes.domain.input.usuario.CadastrarUsuarioRequest;
import com.fiap.tc.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.tc.restaurantes.utils.usuario.UsuarioHelper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsuarioStepDefinition {
  private Response response;
  private UsuarioResponse usuarioResponse;
  private final String ENDPOINT_API_MENSAGENS = "http://localhost:8080/usuarios";

  @Quando("registrar um novo usuario")
  public UsuarioResponse registrar_um_novo_usuario() {
    CadastrarUsuarioRequest request = UsuarioHelper.gerarCadastrarUsuarioRequest();

    response = given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post(ENDPOINT_API_MENSAGENS);

    return response.then().extract().as(UsuarioResponse.class);
  }

  @Então("o usuario é registrado com sucesso")
  public void o_usuario_é_registrado_com_sucesso() {
    response.then()
        .statusCode(HttpStatus.CREATED.value());
  }

  @Então("o usuario deve ser apresentado")
  public void o_usuario_deve_ser_apresentado() {
    response.then()
        .body(matchesJsonSchemaInClasspath("schemas/usuario/usuario.schema.json"));
  }

  @Dado("que um usuario ja esta cadastrado")
  public void que_um_usuario_ja_esta_cadastrado() {
    usuarioResponse = registrar_um_novo_usuario();
  }

  @Quando("efetuar a busca de usuario")
  public void efetuar_a_busca_de_usuario() {
    response = when()
        .get(ENDPOINT_API_MENSAGENS + "/{id}", usuarioResponse.usuarioId());
  }

  @Então("o usuario é exibido com sucesso")
  public void o_usuario_é_exibido_com_sucesso() {
    response.then()
        .body(matchesJsonSchemaInClasspath("schemas/usuario/usuario.schema.json"));
  }

  @Então("efeturar a requisição para atualizar o usuario")
  public void efeturar_a_requisição_para_atualizar_o_usuario() {
    Usuario usuario = UsuarioHelper.gerarUsuarioValido();
    usuario.setNome("João");
    usuario.setSenha("Senha@98752");
    usuario.setTelefone("00000000000");

    AtualizarUsuarioRequest request = new AtualizarUsuarioRequest(
        usuario.getNome(),
        usuario.getEmail(),
        usuario.getSenha(),
        usuario.getTelefone()
    );

    response =
        given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .put(ENDPOINT_API_MENSAGENS + "/{id}", usuarioResponse.usuarioId());
  }

  @Então("o usuario é atualizado com sucesso")
  public void o_usuario_é_atualizado_com_sucesso() {
    response.then()
        .statusCode(HttpStatus.OK.value());
  }

  @Quando("requisitar a remoção do usuario")
  public void requisitar_a_remoção_do_usuario() {
    response = when()
        .delete(ENDPOINT_API_MENSAGENS + "/{id}", usuarioResponse.usuarioId());
  }

  @Então("o usuario é removido com sucesso")
  public void o_usuario_é_removido_com_sucesso() {
    response.then()
        .statusCode(HttpStatus.OK.value());
  }

  @Então("deve apresentar o resultado da remoção")
  public void deve_apresentar_o_resultado_da_remoção() {
    response.then()
        .body(matchesJsonSchemaInClasspath("schemas/usuario/usuarioDeletado.schema.json"));
  }
}
