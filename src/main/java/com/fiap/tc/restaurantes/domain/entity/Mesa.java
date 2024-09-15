package com.fiap.tc.restaurantes.domain.entity;

import com.fiap.tc.restaurantes.domain.enums.StatusMesaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mesa {
    private Long mesaId;
    private Long restauranteId;
    private StatusMesaEnum status;
    private Integer quantidadeAssentos;


}

