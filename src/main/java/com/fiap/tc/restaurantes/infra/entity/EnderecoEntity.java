package com.fiap.tc.restaurantes.infra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EnderecoEntity {

    @Id
    @GeneratedValue
    private Long enderecoId;

    @NotBlank
    private String rua;

    @NotBlank
    private String logradouro;

    @NotNull
    private Integer numero;

    @NotBlank
    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @Pattern(regexp = "[0-9]{8}")
    @NotBlank
    private String cep;

    @NotBlank
    private String estado;

    @Size(min = 2, max = 2)
    @NotBlank
    private String uf;

}
