package com.fiap.tc.restaurantes.utils.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.infra.entity.UsuarioEntity;

public class UsuarioHelper {

  public static Usuario gerarUsuarioValidoComId() {
    Long id = 1L;
    String nome = "Lucas";
    String email = "lucas@mail.com";
    String telefone = "000000000";
    String senha = "aA@4b7c8";
    Usuario usuario = new Usuario(nome, email, senha, telefone);
    usuario.setUsuarioId(id);
    return usuario;
  }

  public static Usuario gerarUsuarioValido() {
    String nome = "Lucas";
    String email = "lucas@mail.com";
    String telefone = "000000000";
    String senha = "aA@4b7c8";
    return  new Usuario(nome, email, senha, telefone);
  }

  public static UsuarioEntity gerarUsuarioEntity() {
    String nome = "Lucas";
    String email = "lucas@mail.com";
    String telefone = "000000000";
    String senha = "aA@4b7c8";
    return  new UsuarioEntity(nome, email, senha, telefone);
  }

  public static Usuario gerarUsuarioComNomeVazio() {
    String nome = "";
    String email = "lucas@mail.com";
    String telefone = "000000000";
    String senha = "aA@4b7c";
    return  new Usuario(nome, email, senha, telefone);
  }

  public static Usuario gerarUsuarioComEmailInvalido() {
    String nome = "Lucas";
    String email = "lucas.com";
    String telefone = "000000000";
    String senha = "aA@4b7c";
    return  new Usuario(nome, email, senha, telefone);
  }

  public static Usuario gerarUsuarioComSenhaInvalida() {
    String nome = "Lucas";
    String email = "lucas@mail.com";
    String telefone = "000000000";
    String senha = "123senhainvalida";
    return  new Usuario(nome, email, senha, telefone);
  }

  public static Usuario gerarUsuarioComTelefoneVazio() {
    String nome = "Lucas";
    String email = "lucas@mail.com";
    String telefone = "";
    String senha = "123senhainvalida";
    return  new Usuario(nome, email, senha, telefone);
  }
}
