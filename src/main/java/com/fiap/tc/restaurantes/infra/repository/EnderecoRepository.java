package com.fiap.tc.restaurantes.infra.repository;

import com.fiap.tc.restaurantes.infra.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
}
