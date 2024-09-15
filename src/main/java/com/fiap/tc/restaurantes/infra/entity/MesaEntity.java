package com.fiap.tc.restaurantes.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class MesaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long mesaId;

  @ManyToOne
  @JoinColumn(name = "restaurante_id", nullable = false)
  private RestauranteEntity restaurante;

  @Column(nullable = false)
  private int status;

  @Column(nullable = false)
  private Integer quantidadeAssentos;
}
