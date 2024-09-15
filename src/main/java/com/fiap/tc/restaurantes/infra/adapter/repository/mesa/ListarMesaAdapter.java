package com.fiap.tc.restaurantes.infra.adapter.repository.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.mesa.ListarMesasInterface;
import com.fiap.tc.restaurantes.infra.entity.MesaEntity;
import com.fiap.tc.restaurantes.infra.repository.MesaRepository;
import com.fiap.tc.restaurantes.infra.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.MesaEntityMapper;
import com.fiap.tc.restaurantes.infra.repository.mapper.UsuarioEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarMesaAdapter implements ListarMesasInterface {
    private final MesaRepository mesaRepository;
    private final MesaEntityMapper mesaEntityMapper;


    @Override
    public List<Usuario> listarUsuarios() {
        return mesaRepository.findAll().stream().map(mesaEntityMapper::toMesa).toList();
    }
}
