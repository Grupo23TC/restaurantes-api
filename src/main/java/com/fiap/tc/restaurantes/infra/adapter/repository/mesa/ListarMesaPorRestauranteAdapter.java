package com.fiap.tc.restaurantes.infra.adapter.repository.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.gateway.mesa.ListarMesasPorRestauranteInterface;
import com.fiap.tc.restaurantes.infra.repository.MesaRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.MesaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarMesaPorRestauranteAdapter implements ListarMesasPorRestauranteInterface {

    private final MesaRepository mesaRepository;
    private final MesaEntityMapper mesaEntityMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Mesa> listarMesasPorRestaurante(Long restauranteId) {
        return mesaRepository.findByRestaurante(restauranteId)
                .stream()
                .map(mesaEntityMapper::toMesa)
                .toList();
    }
}
