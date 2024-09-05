package com.fiap.tc.restaurantes.adapters.in.controller.usuario.request;

public record AtualizarUsuarioRequest(
    String nome,
    String email,
    String senha,
    String telefone
) {
}
