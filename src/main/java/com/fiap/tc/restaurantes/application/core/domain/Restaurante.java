package com.fiap.tc.restaurantes.application.core.domain;

import com.fiap.tc.restaurantes.application.core.domain.enumeration.TipoCozinhaEnum;
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
