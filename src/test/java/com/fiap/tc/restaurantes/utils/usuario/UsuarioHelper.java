package com.fiap.tc.restaurantes.utils.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.infra.entity.UsuarioEntity;

public class UsuarioHelper {

    public static Usuario gerarUsuario() {
        Usuario usuario = new Usuario(1L,
                "usuario teste",
                "email@email.com",
                "senha123",
                "99999-9999");
        return usuario;
    }

    public static UsuarioEntity gerarUsuarioEntity() {
        UsuarioEntity usuario = new UsuarioEntity(1L,
                "usuario teste",
                "email@email.com",
                "senha123",
                "99999-9999");
        return usuario;
    }
}
