package com.fiap.tc.restaurantes.domain.entity;

import com.fiap.tc.restaurantes.domain.enums.EstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String rua;

    private String logradouro;

    private Integer numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String cep;

    private String uf;

    /**
     * Retorna o nome do estado
     * @return
     */
    public String getEstado() {
        var estadoEnum = EstadoEnum.getEnum(uf);
        return estadoEnum == null ? "" : estadoEnum.nome();
    }

}