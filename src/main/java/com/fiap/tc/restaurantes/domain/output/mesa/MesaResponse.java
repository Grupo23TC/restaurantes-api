package com.fiap.tc.restaurantes.domain.output.mesa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MesaResponse {

    private Long mesaId;
    private String descricao;
    private int capacidade;
    private boolean disponivel;

}