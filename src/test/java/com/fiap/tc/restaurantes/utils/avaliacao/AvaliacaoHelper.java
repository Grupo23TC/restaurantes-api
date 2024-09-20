package com.fiap.tc.restaurantes.utils.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.input.avaliacao.AtualizarAvaliacaoRequest;
import com.fiap.tc.restaurantes.domain.input.avaliacao.CadastrarAvaliacaoRequest;
import com.fiap.tc.restaurantes.domain.output.avaliacao.AvaliacaoResponse;
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

    public static CadastrarAvaliacaoRequest gerarCadastrarAvaliacaoRequest() {
        CadastrarAvaliacaoRequest avaliacao = new CadastrarAvaliacaoRequest(
                1L,
                1L,
                4,
                "Muito Bom"
        );

        return avaliacao;
    }

    public static CadastrarAvaliacaoRequest gerarCadastrarAvaliacaoRequestRestauranteInexistente() {
        CadastrarAvaliacaoRequest avaliacao = new CadastrarAvaliacaoRequest(
                151984515588L,
                1L,
                4,
                "Muito Bom"
        );

        return avaliacao;
    }

    public static CadastrarAvaliacaoRequest gerarCadastrarAvaliacaoRequestUsuarioInexistente() {
        CadastrarAvaliacaoRequest avaliacao = new CadastrarAvaliacaoRequest(
                1L,
                51658495122L,
                4,
                "Muito Bom"
        );

        return avaliacao;
    }

    public static CadastrarAvaliacaoRequest gerarCadastrarAvaliacaoRequestNotaInvalida() {
        CadastrarAvaliacaoRequest avaliacao = new CadastrarAvaliacaoRequest(
                1L,
                1L,
                15522,
                "Muito Bom"
        );

        return avaliacao;
    }

    public static AtualizarAvaliacaoRequest gerarAtualizarAvaliacaoRequest() {
        AtualizarAvaliacaoRequest avaliacao = new AtualizarAvaliacaoRequest(
                1,
                "Horrivel"
        );

        return avaliacao;
    }

    public static AtualizarAvaliacaoRequest gerarAtualizarAvaliacaoRequestComNotaInvalida() {
        AtualizarAvaliacaoRequest avaliacao = new AtualizarAvaliacaoRequest(
                18,
                "Horrivel"
        );

        return avaliacao;
    }
}
