package com.fiap.tc.restaurantes.utils.avaliacao;

import com.fiap.tc.restaurantes.infra.entity.AvaliacaoEntity;
import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.infra.entity.UsuarioEntity;

public class AvaliacaoHelper {

    public static AvaliacaoEntity gerarAvaliacaoEntity() {
        AvaliacaoEntity avaliacao = new AvaliacaoEntity();
        UsuarioEntity usuario = new UsuarioEntity();
        RestauranteEntity restaurante = new RestauranteEntity();

        usuario.setUsuarioId(1L);
        restaurante.setRestauranteId(1L);

        avaliacao.setUsuarioEntity(usuario);
        avaliacao.setRestauranteEntity(restaurante);
        avaliacao.setNota(5);
        avaliacao.setComentario("Comentário teste");
        return avaliacao;
    }
}
