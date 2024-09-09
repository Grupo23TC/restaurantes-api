package com.fiap.tc.restaurantes.domain.useCase.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.entity.validations.AvaliacaoValidation;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.CadastrarAvaliacaoInterface;
import com.fiap.tc.restaurantes.domain.useCase.restaurante.BuscarRestaurantePorIdUseCase;
import com.fiap.tc.restaurantes.domain.useCase.usuario.BuscarUsuarioPorIdUseCase;

public class CadastrarAvaliacaoUseCase {

    private final CadastrarAvaliacaoInterface cadastrarAvaliacaoInterface;
    private final BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;
    private final BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;

    public CadastrarAvaliacaoUseCase(CadastrarAvaliacaoInterface cadastrarAvaliacaoInterface, BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase, BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase) {
        this.cadastrarAvaliacaoInterface = cadastrarAvaliacaoInterface;
        this.buscarUsuarioPorIdUseCase = buscarUsuarioPorIdUseCase;
        this.buscarRestaurantePorIdUseCase = buscarRestaurantePorIdUseCase;
    }

    public Avaliacao execute(Avaliacao avaliacao) {

        //Valida se Usuario existe
        buscarUsuarioPorIdUseCase.execute(avaliacao.getUsuario().getUsuarioId());
        //Valida se Restaurate existe
        buscarRestaurantePorIdUseCase.execute(avaliacao.getRestaurante().getRestauranteId());

        AvaliacaoValidation.validate(avaliacao);

        return cadastrarAvaliacaoInterface.cadastraAvaliacao(avaliacao);
    }
}
