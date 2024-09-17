package com.fiap.tc.restaurantes.domain.entity;

import com.fiap.tc.restaurantes.domain.enums.TipoCozinhaEnum;


public class Restaurante {

    private Long restauranteId;
    private String nome;
    private Endereco endereco;
    private TipoCozinhaEnum tipoDeCozinha;
    private Integer capacidade;
    private String horarioFuncionamento;

    public Restaurante(Long restauranteId, String nome, Endereco endereco, TipoCozinhaEnum tipoDeCozinha, Integer capacidade, String horarioFuncionamento) {
        this.restauranteId = restauranteId;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.capacidade = capacidade;
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public Restaurante() {
    }

    public Long getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoCozinhaEnum getTipoDeCozinha() {
        return tipoDeCozinha;
    }

    public void setTipoDeCozinha(TipoCozinhaEnum tipoDeCozinha) {
        this.tipoDeCozinha = tipoDeCozinha;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }
}
