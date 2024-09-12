package com.fiap.tc.restaurantes.utils.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Endereco;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.enums.TipoCozinhaEnum;
import com.fiap.tc.restaurantes.infra.entity.EnderecoEntity;
import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;
public class RestauranteHelper {

    public static RestauranteEntity gerarRestauranteEntityValido() {
        String nome = "Nome Teste";
        Integer capacidade = 100;
        String tipoCozinhaEnum = "MEXICANA";
        String horarioFuncionamento = "10 as 11";
        return new RestauranteEntity(1L, nome,
                builder(),
                tipoCozinhaEnum, capacidade, horarioFuncionamento);
    }

    public static EnderecoEntity builder(){
        return EnderecoEntity.builder()
                .rua("Rua Teste")
                .bairro("")
                .cidade("")
                .complemento("")
                .logradouro("")
                .numero(123)
                .estado("")
                .uf("")
                .build();
    }

    public static Restaurante gerarRestaurante() {
        String nome = "Nome Teste";
        Integer capacidade = 100;
        TipoCozinhaEnum tipoCozinhaEnum = TipoCozinhaEnum.MEXICANA;
        String horarioFuncionamento = "10 as 11";
        return new Restaurante(1L, nome,
                gerarEndereco(),
                tipoCozinhaEnum, capacidade, horarioFuncionamento);
    }

    public static Endereco gerarEndereco(){
        return new Endereco("Rua teste",
                "logradouro teste",
                1,
                "apto 1",
                "bairro teste",
                "cidade teste",
                "99999-999",
                "SP");
    }
}
