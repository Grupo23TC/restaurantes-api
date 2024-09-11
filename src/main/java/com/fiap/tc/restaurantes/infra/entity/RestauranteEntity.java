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
public class RestauranteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long restauranteId;

  @Column(nullable = false)
  private String nome;

  @OneToOne
  @JoinColumn(name="enderecoId")
  private EnderecoEntity endereco;

  @Column(nullable = false)
  private String tipoDeCozinha;

  @Column(nullable = false)
  private Integer capacidade;

  @Column(nullable = false)
  private String horarioFuncionamento;
}
