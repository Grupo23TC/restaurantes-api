package com.fiap.tc.restaurantes.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
  private Long usuarioId;
  private String nome;
  private String email;
  private String senha;
  private String telefone;
}
