package com.fiap.tc.restaurantes.utils.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.infra.entity.AvaliacaoEntity;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
import com.fiap.tc.restaurantes.utils.usuario.UsuarioHelper;

public class AvaliacaoHelper {

    public static AvaliacaoEntity gerarAvaliacaoEntity() {
        AvaliacaoEntity avaliacao = new AvaliacaoEntity();

        avaliacao.setUsuarioEntity(UsuarioHelper.gerarUsuarioEntity());
        avaliacao.setRestauranteEntity(RestauranteHelper.gerarRestauranteEntityValido());
        avaliacao.setNota(5);
        avaliacao.setComentario("Comentário teste");
        return avaliacao;
    }

    public static Avaliacao gerarAvaliacao() {
        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setUsuario(UsuarioHelper.gerarUsuarioValidoComId());
        avaliacao.setRestaurante(RestauranteHelper.gerarRestaurante());
        avaliacao.setNota(5);
        avaliacao.setComentario("Comentário teste");
        return avaliacao;
    }
}
