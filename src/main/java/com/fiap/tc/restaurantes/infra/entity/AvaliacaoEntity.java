package com.fiap.tc.restaurantes.infra.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "avaliacao")
public class AvaliacaoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long avaliacaoId;

  @OneToOne
  @JoinColumn(name = "restauranteId")
  private RestauranteEntity restauranteEntity;

  @OneToOne
  @JoinColumn(name = "usuarioId")
  private UsuarioEntity usuarioEntity;

  private Integer nota;
  private String comentario;
}
