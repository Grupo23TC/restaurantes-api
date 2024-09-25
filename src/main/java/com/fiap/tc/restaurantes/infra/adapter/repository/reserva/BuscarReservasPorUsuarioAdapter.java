package com.fiap.tc.restaurantes.infra.adapter.repository.reserva;

import com.fiap.tc.restaurantes.domain.entity.Reserva;
import com.fiap.tc.restaurantes.domain.gateway.reserva.BuscarReservasPorUsuarioInterface;
import com.fiap.tc.restaurantes.infra.entity.ReservaEntity;
import com.fiap.tc.restaurantes.infra.repository.ReservaRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.ReservaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarReservasPorUsuarioAdapter implements BuscarReservasPorUsuarioInterface {

    private final ReservaRepository reservaRepository;
    private final ReservaEntityMapper mapper;

    @Override
    public List<Reserva> buscarReservasPorUsuario(Long usuarioId) {
        List<ReservaEntity> reservaEntityList = reservaRepository.buscarReservasPorUsuario(usuarioId);
        return reservaEntityList.stream().map(mapper::toReserva).toList();
    }
}
