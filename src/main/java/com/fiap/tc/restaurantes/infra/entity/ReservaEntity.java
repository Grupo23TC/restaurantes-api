package com.fiap.tc.restaurantes.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaEntity {
  private Long reservaId;
  private Long mesaId;
  private Long usuarioId;
  private LocalDateTime data;
}
