package com.fiap.tc.restaurantes.infra.repository;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
