package com.fiap.tc.restaurantes.adapters.out.repository;

import com.fiap.tc.restaurantes.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.application.core.domain.enumeration.TipoCozinhaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
  List<RestauranteEntity> findByNomeContaining(String nome);
  List<RestauranteEntity> findByTipoDeCozinha(String tipoCozinhaEnum);
}
