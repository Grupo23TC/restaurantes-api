package com.fiap.tc.restaurantes.infra.adapter.out.endereco;

import com.fiap.tc.restaurantes.infra.feign.ConsultarEnderecoPorCepClient;
import com.fiap.tc.restaurantes.domain.mapper.endereco.EnderecoResponseMapper;
import com.fiap.tc.restaurantes.domain.entity.Endereco;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class ConsultarEnderecoPorCepAdapter implements ConsultarEnderecoPorCepInterface {

    private final ConsultarEnderecoPorCepClient consultarEnderecoPorCepClient;

    private final EnderecoResponseMapper enderecoResponseMapper;

    @Override
    public Endereco consultaPorCep(String cep) {
        var enderecoResponse = consultarEnderecoPorCepClient.consultaPorCep(cep);
        return enderecoResponseMapper.toEndereco(enderecoResponse);
    }

}
