package com.fiap.tc.restaurantes.domain.entity;

import com.fiap.tc.restaurantes.domain.enums.EstadoEnum;

public class Endereco {

    private String rua;

    private String logradouro;

    private Integer numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String cep;

    private String uf;

    public Endereco(String rua, String logradouro, Integer numero, String complemento, String bairro, String cidade, String cep, String uf) {
        this.rua = rua;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
    }

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * Retorna o nome do estado
     * @return
     */
    public String getEstado() {
        var estadoEnum = EstadoEnum.getEnum(uf);
        return estadoEnum == null ? "" : estadoEnum.nome();
    }

}