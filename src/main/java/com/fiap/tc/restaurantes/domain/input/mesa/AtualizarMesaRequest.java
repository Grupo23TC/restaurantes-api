package com.fiap.tc.restaurantes.domain.input.mesa;

import org.jetbrains.annotations.NotNull;

public class AtualizarMesaRequest {

    @NotNull
    private Long restauranteId;

    @NotNull
    private Integer quantidadeAssentos;

    public AtualizarMesaRequest(@NotNull Long restauranteId, @NotNull Integer quantidadeAssentos) {
        this.restauranteId = restauranteId;
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public Long getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }

    public Integer getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public void setQuantidadeAssentos(Integer quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }
}