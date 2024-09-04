package com.fiap.tc.restaurantes.utils.usuario;

import com.fiap.tc.restaurantes.adapters.out.repository.entity.UsuarioEntity;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;

public class UsuarioHelper {
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
