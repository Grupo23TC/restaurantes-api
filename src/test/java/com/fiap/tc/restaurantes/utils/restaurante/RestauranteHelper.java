package com.fiap.tc.restaurantes.utils.restaurante;

import com.fiap.tc.restaurantes.adapters.out.repository.entity.EnderecoEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.RestauranteEntity;
public class RestauranteHelper {

    public static RestauranteEntity gerarRestauranteValido() {
        String nome = "Nome Teste";
        Integer capacidade = 100;
        String tipoCozinhaEnum = "MEXICANA";
        String horarioFuncionamento = "10 as 11";
        return new RestauranteEntity(1L, nome,
                builder(),
                tipoCozinhaEnum, capacidade, horarioFuncionamento);
    }

    public static EnderecoEntity builder(){
        EnderecoEntity endereco = EnderecoEntity.builder()
                .rua("Rua Teste")
                .bairro("")
                .cidade("")
                .complemento("")
                .logradouro("")
                .numero(123)
                .estado("")
                .uf("")
                .build();

        return endereco;
    }
}
