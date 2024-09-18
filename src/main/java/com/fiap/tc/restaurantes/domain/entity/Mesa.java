package com.fiap.tc.restaurantes.domain.entity;

import com.fiap.tc.restaurantes.domain.enums.StatusMesaEnum;

public class Mesa {
    private Long mesaId;
    private Restaurante restaurante;
    private StatusMesaEnum status;
    private Integer quantidadeAssentos;


    public Mesa(Long mesaId, Restaurante restaurante, StatusMesaEnum status, Integer quantidadeAssentos) {
        this.mesaId = mesaId;
        this.restaurante = restaurante;
        this.status = status;
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public Mesa() {
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public StatusMesaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusMesaEnum status) {
        this.status = status;
    }

    public Integer getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public void setQuantidadeAssentos(Integer quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }
}

