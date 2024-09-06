package com.fiap.tc.restaurantes.domain.input.restaurante;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastrarRestauranteRequest(
        @NotBlank String nome,
        @NotBlank Endereco endereco,
        @NotBlank String tipoDeCozinha,
        @NotNull Integer capacidade,
        @NotBlank String horarioFuncionamento
) {
    public record Endereco(


            @NotBlank String rua,


            @NotBlank String logradouro,


            @NotNull Integer numero,


            @NotBlank String complemento,

            @NotBlank String bairro,

            @NotBlank @Pattern(regexp = "[0-9]{8}",
                    message = "O CEP deve conter somente número com 8 posições") String cep,
            @NotBlank String cidade,
            @NotBlank String uf) {
    }
}
