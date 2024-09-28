package com.fiap.tc.restaurantes.infra.adapter.repository.mesa;

import com.fiap.tc.restaurantes.domain.gateway.mesa.DeletarMesaInterface;
import com.fiap.tc.restaurantes.infra.repository.MesaRepository;
import org.springframework.stereotype.Component;

@Component
public class DeletarMesaAdapter implements DeletarMesaInterface {

    private final MesaRepository mesaRepository;

    public DeletarMesaAdapter(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @Override
    public boolean deletarMesa(Long mesaId) {
        mesaRepository.deleteById(mesaId);
        return true;
    }

}
