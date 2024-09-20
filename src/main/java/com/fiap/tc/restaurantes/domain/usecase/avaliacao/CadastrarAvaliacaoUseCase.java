package com.fiap.tc.restaurantes.domain.usecase.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.entity.validations.AvaliacaoValidation;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.CadastrarAvaliacaoInterface;
import com.fiap.tc.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorIdUseCase;
import com.fiap.tc.restaurantes.domain.usecase.usuario.BuscarUsuarioPorIdUseCase;

public class CadastrarAvaliacaoUseCase {

    private final CadastrarAvaliacaoInterface cadastrarAvaliacaoInterface;
    private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;
    private final BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;

    public CadastrarAvaliacaoUseCase(CadastrarAvaliacaoInterface cadastrarAvaliacaoInterface, BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase, BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase) {
        this.cadastrarAvaliacaoInterface = cadastrarAvaliacaoInterface;
        this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
        this.buscarRestaurantePorIdUseCase = buscarRestaurantePorIdUseCase;
    }

    public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao, Long restauranteId, Long usuarioId) {

        //Valida se Usuario existe
        Usuario usuario = buscarUsuarioPorIdUseCase.buscarUsuarioPorId(usuarioId);
        //Valida se Restaurate existe
        Restaurante restaurante = buscarRestaurantePorIdUseCase.buscarRestaurantePorId(restauranteId);

        avaliacao.setUsuario(usuario);
        avaliacao.setRestaurante(restaurante);

        AvaliacaoValidation.validate(avaliacao);

        return cadastrarAvaliacaoInterface.cadastraAvaliacao(avaliacao);
    }
}
