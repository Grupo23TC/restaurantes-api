package com.fiap.tc.restaurantes.domain.output.endereco;

public record EnderecoResponse(String cep, String logradouro, String complemento, String bairro, String localidade,
                               String uf, String rua, Integer numero) {

}