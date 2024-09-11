package com.fiap.tc.restaurantes.utils.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.infra.entity.UsuarioEntity;

public class UsuarioHelper {

    public static Usuario gerarUsuario() {
        return new Usuario(1L,
                "usuario teste",
                "email@email.com",
                "senha123",
                "99999-9999");

    }

    public static UsuarioEntity gerarUsuarioEntity() {
        return new UsuarioEntity(1L,
                "usuario teste",
                "email@email.com",
                "senha123",
                "99999-9999");
    }
}
