package com.fiap.tc.restaurantes.adapters.out.repository;

import com.fiap.tc.restaurantes.adapters.out.repository.entity.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
}
