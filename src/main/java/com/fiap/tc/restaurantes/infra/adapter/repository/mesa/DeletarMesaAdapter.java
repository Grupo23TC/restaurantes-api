package com.fiap.tc.restaurantes.infra.adapter.repository.mesa;

import com.fiap.tc.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.tc.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.tc.restaurantes.infra.repository.MesaRepository;
import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class DeletarMesaAdapter {

    private final MesaRepository mesaRepository;
    private final MesaMapper mesaMapper;

    public DeletarMesaAdapter(MesaRepository mesaRepository, MesaMapper mesaMapper) {
        this.mesaRepository = mesaRepository;
        this.mesaMapper = mesaMapper;
    }

    public boolean deletarRestaurante(Long id) {
        // TODO implementar verificacao se restaurante existe
        mesaRepository.deleteById(id);
        return true;
    }



}
