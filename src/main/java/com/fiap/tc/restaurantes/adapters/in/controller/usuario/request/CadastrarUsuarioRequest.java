package com.fiap.tc.restaurantes.adapters.in.controller.usuario.request;

public record CadastrarUsuarioRequest(
    String nome,
    String email,
    String senha,
    String telefone
) {
}
