package com.fiap.tc.restaurantes.adapters.in.controller.usuario.response;

public record UsuarioResponse(
    Long usuarioId,
    String nome,
    String email,
    String senha,
    String telefone
) {
}
