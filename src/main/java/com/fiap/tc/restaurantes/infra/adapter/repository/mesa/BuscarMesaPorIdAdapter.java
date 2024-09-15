package com.fiap.tc.restaurantes.infra.adapter.repository.mesa;

import com.fiap.tc.restaurantes.infra.repository.MesaRepository;
import com.fiap.tc.restaurantes.infra.entity.MesaEntity;
import com.fiap.tc.restaurantes.infra.repository.mapper.MesaEntityMapper;
import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.gateway.mesa.BuscarMesaPorIdInterface;
import org.springframework.stereotype.Component;

@Component
public class BuscarMesaPorIdAdapter implements BuscarMesaPorIdInterface {

    private final MesaRepository mesaRepository;
    private final MesaEntityMapper mesaEntityMapper;
       public BuscarMesaPorIdAdapter(MesaRepository mesaRepository, MesaEntityMapper mesaEntityMapper) {
        this.mesaRepository = mesaRepository;
        this.mesaEntityMapper = mesaEntityMapper;
    }

    @Override
    public Mesa buscarMesaPorId(Long id) {
        Mesa mesaBuscada = mesaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id da mesa não encontrado"));


        return mesaEntityMapper.toMesa(mesaBuscada);
    }
}