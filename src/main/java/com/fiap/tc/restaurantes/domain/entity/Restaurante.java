package com.fiap.tc.restaurantes.domain.entity;

import com.fiap.tc.restaurantes.domain.enums.TipoCozinhaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurante {

    private Long restauranteId;
    private String nome;
    private Endereco endereco;
    private TipoCozinhaEnum tipoDeCozinha;
    private Integer capacidade;
    private String horarioFuncionamento;


}
