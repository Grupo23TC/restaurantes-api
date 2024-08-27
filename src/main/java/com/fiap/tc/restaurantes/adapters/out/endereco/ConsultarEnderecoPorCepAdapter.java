package com.fiap.tc.restaurantes.adapters.out.endereco;

import com.fiap.tc.restaurantes.adapters.out.client.ConsultarEnderecoPorCepClient;
import com.fiap.tc.restaurantes.adapters.out.client.mapper.EnderecoResponseMapper;
import com.fiap.tc.restaurantes.application.core.domain.Endereco;
import com.fiap.tc.restaurantes.application.ports.out.ConsultarEnderecoPorCepOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class ConsultarEnderecoPorCepAdapter implements ConsultarEnderecoPorCepOutputPort {

    private final ConsultarEnderecoPorCepClient consultarEnderecoPorCepClient;

    private final EnderecoResponseMapper enderecoResponseMapper;

    @Override
    public Endereco consultaPorCep(String cep) {
        var enderecoResponse = consultarEnderecoPorCepClient.consultaPorCep(cep);
        return enderecoResponseMapper.toEndereco(enderecoResponse);
    }

}
