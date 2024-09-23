package com.fiap.tc.restaurantes.infra.adapter.repository.reserva;

import com.fiap.tc.restaurantes.domain.gateway.reserva.DeletarReservaInterface;
import com.fiap.tc.restaurantes.infra.repository.ReservaRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.ReservaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarReservaAdapter implements DeletarReservaInterface {

    private final ReservaRepository reservaRepository;
    private final ReservaEntityMapper mapper;

    @Override
    public boolean deletarReserva(Long reservaId) {
        reservaRepository.deleteById(reservaId);
        return true;
    }
}
