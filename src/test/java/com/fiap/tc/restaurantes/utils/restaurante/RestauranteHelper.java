package com.fiap.tc.restaurantes.utils.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Endereco;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.enums.TipoCozinhaEnum;
import com.fiap.tc.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.tc.restaurantes.infra.entity.EnderecoEntity;
import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;

import java.util.List;

public class RestauranteHelper {
    public static Restaurante gerarRestaurante() {
        String nome = "Nome Teste";
        Integer capacidade = 100;
        String horarioFuncionamento = "10 as 11";
        return new Restaurante(1L, nome,
                gerarEndereco(),
            TipoCozinhaEnum.MEXICANA, capacidade, horarioFuncionamento, List.of());
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

    public static RestauranteEntity gerarRestauranteEntityValido() {
        String nome = "Nome Teste";
        Integer capacidade = 100;
        String tipoCozinhaEnum = "MEXICANA";
        String horarioFuncionamento = "10 as 11";
        return new RestauranteEntity(1L, nome,
            enderecoEntityBuilder(),
            tipoCozinhaEnum, capacidade, horarioFuncionamento);
    }

    // TODO: Remover um dos dois método de gerarRestauranteValido
    public static Restaurante gerarRestauranteValido() {
        String nome = "Nome Teste";
        Integer capacidade = 100;
        String horarioFuncionamento = "10 as 11";
        return new Restaurante(1L, nome,
            enderecoBuilder(),
            TipoCozinhaEnum.MEXICANA, capacidade, horarioFuncionamento, List.of());
    }

    public static Restaurante entityToRestaurante(RestauranteEntity restauranteEntity){
        Restaurante restaurante = new Restaurante();
        restaurante.setRestauranteId(restauranteEntity.getRestauranteId());
        restaurante.setEndereco(enderecoBuilder());
        restaurante.setNome(restauranteEntity.getNome());
        restaurante.setCapacidade(restauranteEntity.getCapacidade());
        restaurante.setTipoDeCozinha(TipoCozinhaEnum.MEXICANA);
        restaurante.setCapacidade(restauranteEntity.getCapacidade());

        return restaurante;
    }

    public static RestauranteResponse gerarRestauranteResponse(){
        String nome = "Nome Teste";
        Integer capacidade = 100;
        String tipoCozinhaEnum = "MEXICANA";
        String horarioFuncionamento = "10 as 11";

        return new RestauranteResponse(
            1L, nome, null, tipoCozinhaEnum
            , capacidade, horarioFuncionamento);
    }

    public static EnderecoEntity enderecoEntityBuilder(){
        return EnderecoEntity.builder()
            .rua("Rua Teste")
            .bairro("bairro teste")
            .cidade("cidade teste")
            .complemento("apto 1")
            .cep("00000000")
            .logradouro("logradouro teste")
            .numero(1)
            .estado("Sao Paulo")
            .uf("IT")
            .build();
    }

    public static Endereco enderecoBuilder(){
        return Endereco.builder()
            .rua("Rua Teste")
            .bairro("bairro teste")
            .cidade("cidade teste")
            .complemento("apto 1")
            .cep("01001001")
            .logradouro("logradouro teste")
            .numero(1)
            .uf("IT")
            .build();
    }
}
