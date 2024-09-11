package com.fiap.tc.restaurantes.domain.input.usuario;

public record CadastrarUsuarioRequest(
    String nome,
    String email,
    String senha,
    String telefone
) {
}
