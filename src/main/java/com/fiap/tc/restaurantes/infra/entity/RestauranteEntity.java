package com.fiap.tc.restaurantes.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RestauranteEntity {

  public RestauranteEntity(Long restauranteId, String nome, EnderecoEntity endereco, String tipoDeCozinha, Integer capacidade, String horarioFuncionamento) {
    this.restauranteId = restauranteId;
    this.nome = nome;
    this.endereco = endereco;
    this.tipoDeCozinha = tipoDeCozinha;
    this.capacidade = capacidade;
    this.horarioFuncionamento = horarioFuncionamento;
  }

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

  @OneToMany(mappedBy = "restaurante")
  private List<MesaEntity> mesas;
}
