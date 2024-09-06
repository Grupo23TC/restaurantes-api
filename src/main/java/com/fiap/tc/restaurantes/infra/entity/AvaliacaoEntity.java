package com.fiap.tc.restaurantes.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvaliacaoEntity {
  private Long avaliacaoId;
  private Long restauranteId;
  private Long usuarioId;
  private Integer nota;
  private String comentario;
}
