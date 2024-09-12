package com.fiap.tc.restaurantes.domain.entity;


public class Usuario {
  private Long usuarioId;
  private String nome;
  private String email;
  private String senha;
  private String telefone;

  public Usuario(Long usuarioId, String nome, String email, String senha, String telefone) {
    this.usuarioId = usuarioId;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.telefone = telefone;
  }

  public Usuario() {
  }

  public Long getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(Long usuarioId) {
    this.usuarioId = usuarioId;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}
