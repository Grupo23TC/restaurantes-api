package com.fiap.tc.restaurantes.infra.adapter.repository.mesa;

import com.fiap.tc.restaurantes.domain.gateway.mesa.DeletarMesaInterface;
import com.fiap.tc.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.tc.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.tc.restaurantes.infra.repository.MesaRepository;
import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class DeletarMesaAdapter implements DeletarMesaInterface {

    private final MesaRepository mesaRepository;
    private final MesaMapper mesaMapper;

    public DeletarMesaAdapter(MesaRepository mesaRepository, MesaMapper mesaMapper) {
        this.mesaRepository = mesaRepository;
        this.mesaMapper = mesaMapper;
    }

    @Override
    public boolean deletarMesa(Long mesaId) {
        mesaRepository.deleteById(mesaId);
        return true;
    }

}
